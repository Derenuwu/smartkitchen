
window.onload = async () => {
   try {
      const menuData = await fetchURL("http://localhost:8080/smart_kitchen/servlet/dish");
      console.log("menuData->", menuData);
      displayMenu(menuData);
   } catch (error) {
      console.error('There was a problem:', error);
   }
}

function displayMenu(menuData) {
   const menu_table = document.getElementById("meun_body");
   var string_code = "";
   menuData.forEach(element => {
      console.log(element);
      string_code += "<tr><td>" + element.id + "</td><td>" + element.name + "</td><td>" + element.price + "</td></tr>";
   });
   menu_table.innerHTML += string_code;
}

async function fetchURL(url) {
   try {
      const response = await fetch(url);
      if (!response.ok) {
         throw new Error('Network response was not ok');
      }
      const data = await response.json();
      console.log("fetchURL,", data);
      return data;
   } catch (error) {
      console.error('There was a problem with the fetch operation:', error);
      throw error; // 将错误继续传播，以便在调用fetchURL的地方可以捕获它
   }
}

var car = [];

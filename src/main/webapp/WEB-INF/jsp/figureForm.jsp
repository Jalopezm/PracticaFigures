<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head></head>
<body>
<h1>Figure Form</h1>
<a href="/figureList">Figures List</a>
    <form method="post" action="/drawer" onchange="drawFigure()">
    Figure Name: <input type="text" name="figureName" id="figureName">
    <br>
    <label for="figures">Choose a Figure:</label>
    <select name="figures" id="type">
      <option value="circle">Circle</option>
      <option value="triangle">Triangle</option>
      <option value="square">Square</option>
      <option value="pentagon">Pentagon</option>
      <option value="7star">7 Point Star</option>
    </select>
    <br>
        <label for="color">Choose a Color:</label>
    <select name="color" id="color">
          <option value="red">Red</option>
          <option value="blue">Blue</option>
          <option value="grey">Grey</option>
          <option value="yellow">Yellow</option>
          <option value="green">Green</option>
          <option value="black">Black</option>
        </select>
        <br>
    Select Width:<input type="number" name="width" id="width">
    <br>
        Select PositionX:<input type="number" name="positionX" id="positionX">
        <br>
            Select PositionY:<input type="number" name="positionY" id="positionY">
            <br>
        <br>
        <input type="submit" name="Send" value="Send">
        <button name="View" value="View" onclick="drawFigure(); return false;">View</button>
    </form>
    <canvas id="canvas" width="800" height="600" style="border:1px solid black;">
    </canvas>
    <script>
      const c = document.getElementById("canvas");
      const ctx = c.getContext("2d");

    function drawFigure(){
          ctx.clearRect(0,0,c.width,c.height);
          let width = document.getElementById("width").value;
          let type = document.getElementById("type").value;
          let posX = document.getElementById("positionX").value;
          let posY = document.getElementById("positionY").value;
          let color = document.getElementById("color").value;

        switch(type){
        case "circle": drawCircle(width,type,posX,posY,color);
                break;
        case "square": drawSquare(width,type,posX,posY,color);
                break;
         case "triangle": drawTriangle(width,type,posX,posY,color);
                  break;
         case "pentagon": drawPentagon(width,type,posX,posY,color);
                  break;
         }
    }
      function drawSquare(width,type,posX,posY,color){
        ctx.beginPath();
        ctx.lineWidth = "4";
        ctx.strokeStyle = color;
        ctx.rect(posX, posY, width, width);
        ctx.closePath();
        ctx.stroke();
      }
      function drawCircle(width,type,posX,posY,color){
              ctx.beginPath();
              ctx.lineWidth = "4";
              ctx.strokeStyle = color;
              ctx.arc(posX, posY, width, 0,2 * Math.PI);
              ctx.closePath();
              ctx.stroke();
      }
      function drawTriangle(width,type,posX,posY,color){
          let height= (Math.sqrt(3)*Number(width))/2;
                ctx.beginPath();
                ctx.lineWidth = "4";
                ctx.strokeStyle = color;
                ctx.moveTo(Number(posX),  Number(posY));
                ctx.lineTo(Number(posX)+Number(width), Number(posY));
                ctx.lineTo(Number(posX)+Number(width)/2, Number(posY)-height);
                ctx.lineTo(Number(posX)+(Number(width)/2), Number(posY)-height);
                ctx.lineTo(Number(posX),  Number(posY));
                ctx.closePath();
                ctx.stroke();
      }
      function drawPentagon(width,type,posX,posY,color){
           let step  = 2 * Math.PI / 5;
           let shift = (Math.PI / 180.0) * -50;

            ctx.beginPath();
            ctx.moveTo (posX +  width * Math.cos(0), posY +  width *  Math.sin(0));

            for (let i = 0; i <= 5;i++) {
            	let curStep = i * step + shift;
                ctx.lineTo (posX + width * Math.cos(curStep), posY + width * Math.sin(curStep));
            }

            ctx.strokeStyle = color;
            ctx.lineWidth = 4;
            ctx.closePath();
            ctx.stroke();
      }
    </script>
</body>
</html>
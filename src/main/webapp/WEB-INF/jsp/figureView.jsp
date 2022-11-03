<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head></head>
<body>
<h1>Figure View</h1>
    <canvas id="canvas" width="800" height="600" style="border:1px solid black;">
    </canvas>
        <input type="hidden" value=${figure.figureType} id="type">
        <input type="hidden" value=${figure.coordX} id="positionX">
        <input type="hidden" value=${figure.coordY} id="positionY">
        <input type="hidden" value=${figure.width} id="width">
        <input type="hidden" value=${figure.color} id="color">
    <script>
      const c = document.getElementById("canvas");
      const ctx = c.getContext("2d");
      drawFigure();
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
         }
    }
      function drawSquare(width,type,posX,posY,color){
        ctx.beginPath();
        ctx.lineWidth = "4";
        ctx.strokeStyle = color;
        ctx.rect(posX, posY, width, width);
        ctx.stroke();
      }
      function drawCircle(width,type,posX,posY,color){
              ctx.beginPath();
              ctx.lineWidth = "4";
              ctx.strokeStyle = color;
              ctx.arc(posX, posY, width, 0,2 * Math.PI);
              ctx.stroke();
      }
      function drawTriangle(width,type,posX,posY,color){
          let height= (Math.sqrt(3)*Number(width))/2;
                ctx.beginPath();
                ctx.lineWidth = "4";
                ctx.lineWidth = "2";
                ctx.strokeStyle = color;
                ctx.moveTo(Number(posX),  Number(posY));
                ctx.lineTo(Number(posX)+Number(width), Number(posY));
                ctx.lineTo(Number(posX)+Number(width)/2, Number(posY)-height);
                ctx.lineTo(Number(posX)+(Number(width)/2), Number(posY)-height);
                ctx.lineTo(Number(posX),  Number(posY));
                ctx.stroke();
      }
    </script>
</body>
</html>
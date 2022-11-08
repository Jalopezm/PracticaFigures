<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <style>
        <%@include file="/WEB-INF/css/style.css" %>
    </style>
</head>

<body>
    <a href="/drawer" class="button">Draw Figure</a>
    <a href="/figureList" class="button">Figures List</a>
    <a href="/userFigureList" class="button">User Figures List</a>
    <h1>Figure View</h1>
    <div id="view">
        <div id="form">
            <h1>Figure:${figure.name}</h1>
            <label>FigureType
            <input type="text" value=${figure.figureType} id="type"></input>
            </label>
            <label>Coord X
            <input type="text" value=${figure.coordX} id="positionX"></input>
            </label>
            <label>Coord Y
            <input type="text" value=${figure.coordY} id="positionY"></input>
            </label>
            <label>Width
            <input type="text" value=${figure.width} id="width"></input>
            </label>
            <label>Color
            <input type="text" value=${figure.color} id="color"></input>
            </label>
        </div>
    </div>
    <canvas id="canvas" width="800" height="600" style="border:1px solid black;">
    </canvas>
    <script>
        const c = document.getElementById("canvas");
        const ctx = c.getContext("2d");
        drawFigure();
        function drawFigure() {
            ctx.clearRect(0, 0, c.width, c.height);
            let width = document.getElementById("width").value;
            let type = document.getElementById("type").value;
            let posX = document.getElementById("positionX").value;
            let posY = document.getElementById("positionY").value;
            let color = document.getElementById("color").value;

            switch (type) {
                case "circle": drawCircle(width, type, posX, posY, color);
                    break;
                case "square": drawSquare(width, type, posX, posY, color);
                    break;
                case "triangle": drawTriangle(width, type, posX, posY, color);
                    break;
                case "pentagon": drawPentagon(width, type, posX, posY, color);
                    break;
                case "7star": draw7Star(width, type, posX, posY, color);
                    break;
            }
        }
        function drawSquare(width, type, posX, posY, color) {
            ctx.beginPath();
            ctx.lineWidth = "4";
            ctx.strokeStyle = color;
            ctx.rect(posX, posY, width, width);
            ctx.closePath();
            ctx.stroke();
        }
        function drawCircle(width, type, posX, posY, color) {
            ctx.beginPath();
            ctx.lineWidth = "4";
            ctx.strokeStyle = color;
            ctx.arc(posX, posY, width, 0, 2 * Math.PI);
            ctx.closePath();
            ctx.stroke();
        }
        function drawTriangle(width, type, posX, posY, color) {
            let height = (Math.sqrt(3) * Number(width)) / 2;
            ctx.beginPath();
            ctx.lineWidth = "4";
            ctx.strokeStyle = color;
            ctx.moveTo(Number(posX), Number(posY));
            ctx.lineTo(Number(posX) + Number(width), Number(posY));
            ctx.lineTo(Number(posX) + Number(width) / 2, Number(posY) - height);
            ctx.lineTo(Number(posX) + (Number(width) / 2), Number(posY) - height);
            ctx.lineTo(Number(posX), Number(posY));
            ctx.closePath();
            ctx.stroke();
        }
        function drawPentagon(width, type, posX, posY, color) {
            let step = 2 * Math.PI / 5;
            let shift = (Math.PI / 180.0) * -50;

            ctx.beginPath();

            for (let i = 0; i <= 5; i++) {
                let curStep = i * step + shift;
                ctx.lineTo(Number(posX) + Number(width) * Math.cos(curStep), Number(posY) + Number(width) * Math.sin(curStep));
            }

            ctx.strokeStyle = color;
            ctx.lineWidth = 4;
            ctx.closePath();
            ctx.stroke();
        }
        function draw7Star(width, type, posX, posY, color) {
            let outerRadius = Number(width) / 2;
            let innerRadius = outerRadius / 4;
            let rotAngle = Math.PI / 2 * 3;
            let step = Math.PI / 7;

            ctx.beginPath();
            ctx.moveTo(Number(posX), Number(posY) - outerRadius)
            for (i = 0; i < 7; i++) {
                let newX = Number(posX) + Math.cos(rotAngle) * outerRadius;
                let newY = Number(posY) + Math.sin(rotAngle) * outerRadius;
                ctx.lineTo(newX, newY)
                rotAngle += step

                newX = Number(posX) + Math.cos(rotAngle) * innerRadius;
                newY = Number(posY) + Math.sin(rotAngle) * innerRadius;
                ctx.lineTo(newX, newY)
                rotAngle += step
            }
            ctx.lineTo(Number(posX), Number(posY) - (outerRadius));
            ctx.closePath();
            ctx.lineWidth = 4;
            ctx.strokeStyle = color;
            ctx.stroke();

        }
    </script>
</body>

</html>
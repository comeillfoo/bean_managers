let canvas = document.getElementById('working-area');
let ctx = canvas.getContext('2d');
let canvasDiv = document.getElementById('canvas');

let canvasCenterX = canvas.width / 2;
let canvasCenterY = canvas.height / 2;

let r = ""


function drawCanvas(relativeR) {
    ctx.clearRect(0, 0, canvas.width, canvas.height)
    drawLines();
    drawFields()
    drawNick();
    drawPoints(relativeR);
}

function drawLines() {
    //drawing a horizontal line in center
    ctx.beginPath();
    ctx.moveTo(canvasCenterX  * 0, canvasCenterY);
    ctx.lineTo(canvasCenterX  * 2, canvasCenterY);
    ctx.stroke();
    //drawing a vertical line in center
    ctx.moveTo(canvasCenterX, canvasCenterY * 0);
    ctx.lineTo(canvasCenterX, canvasCenterY * 2);
    ctx.stroke();

    ctx.moveTo(canvasCenterX * 1.9, canvasCenterY - 3)
    ctx.lineTo(canvasCenterX * 2, canvasCenterY)
    ctx.lineTo(canvasCenterX * 1.9, canvasCenterY + 3)
    ctx.stroke()

    ctx.moveTo(canvasCenterX - 3, canvasCenterY * 0.1)
    ctx.lineTo(canvasCenterX , canvasCenterY  * 0)
    ctx.lineTo(canvasCenterX + 3, canvasCenterY * 0.1)
    ctx.stroke()
}

function drawNick() {
    for (let i = -2; i <= 2; i++) {
        if (i !== 0) {
            ctx.moveTo(canvasCenterX + (canvasCenterX * 0.4 * i), canvasCenterY + 5);
            ctx.lineTo(canvasCenterX + (canvasCenterX * 0.4 * i), canvasCenterY - 5);
            ctx.stroke();
            ctx.moveTo(canvasCenterX + 5, canvasCenterY + (canvasCenterY * 0.4 * i));
            ctx.lineTo(canvasCenterX - 5, canvasCenterY + (canvasCenterY * 0.4 * i));
            ctx.stroke();
        }
    }
}

function drawPoint(x, y, r, rgbX, rgbY, rgbZ, shift) {
    // console.log("drawPoint: r=" + r);
    let canvasX = canvasCenterX + ((canvasCenterX - canvasCenterX * 0.2) * `${x}`/`${r}` * shift)
    let canvasY = canvasCenterY - ((canvasCenterY - canvasCenterY * 0.2) * `${y}`/`${r}` * shift)
    ctx.beginPath()
    // canvasDots.clearRect(0, 0, cArrows.width, cArrows.height)
    ctx.moveTo(canvasX, canvasY)
    ctx.arc(canvasX, canvasY, 3, 0, 2 * Math.PI, false)
    // canvasDots.fillStyle = '#ff0033'
    ctx.fillStyle = `rgb(${rgbX},${rgbY},${rgbZ})`;
    ctx.fill()
}

function drawPoints(relativeR) {
    // ctx.clearRect(0, 0, cArrows.width, cArrows.height)
    let trArray = $("#resultsTable").children().children(); //get the array of table rows
    if (trArray[1] != undefined) {
        let rgbY = -30;
        let rgbZ = -30;
        for (let i = trArray.length - 1; i > trArray.length - 6; i--) {
            if (i == 0) break;
            let coords = [];

            for (let j = 3; j < 6; j++) {
                coords[j-3] = trArray[i].children[j].innerText;
            }
            let shift = 1;
            if (relativeR != undefined && relativeR != coords[2]) {
                // console.log("Points r= " + coords[2]);
                // coords[2] = relativeR / coords[2];
                shift = coords[2] / relativeR;
            }

            rgbY += 26;
            rgbY += 26;
            drawPoint(...coords, 221, rgbY, rgbZ, shift);
        }
    }
}

function drawFields() {
    ctx.strokeStyle = 'rgba(0,0,0,0)';
    ctx.fillStyle = 'rgba(0,148,215,0.7)';
    ctx.beginPath();
    ctx.fillRect(canvasCenterX, canvasCenterY, -canvasCenterX * 0.4, canvasCenterY * 0.8);

    ctx.moveTo(canvasCenterX, canvasCenterY)
    ctx.lineTo(canvasCenterX * 1.8, canvasCenterY)
    ctx.lineTo(canvasCenterX, canvasCenterY * 1.8)
    ctx.fill()

    ctx.moveTo(canvasCenterX, canvasCenterY)
    ctx.arc(canvasCenterX, canvasCenterY, canvasCenterX * 0.8, Math.PI, Math.PI * 1.5  , false)
    ctx.strokeStyle = 'rgba(0,148,215,0.5)'
    ctx.stroke()
    ctx.fill()
    ctx.strokeStyle = 'rgba(0,0,0,1)'


}

function markUp(char) {
    ctx.font = "14px Verdana"
    ctx.fillStyle = '#ece07c'
    // canvas.clearRect(0, 0, cArrows.width, cArrows.height)

    ctx.fillText(`-${char}`, canvasCenterX * 0.2, canvasCenterY - 10)
    ctx.fillText(`${char}`, canvasCenterX * 1.8, canvasCenterY - 10)
    ctx.fillText(`-${char}/2`, canvasCenterX * 0.6, canvasCenterY - 10)
    ctx.fillText(`${char}/2`, canvasCenterX * 1.4, canvasCenterY - 10)

    ctx.fillText(`${char}`, canvasCenterX + 10, canvasCenterY * 0.2)
    ctx.fillText(`-${char}`, canvasCenterX + 10, canvasCenterY * 1.8)
    ctx.fillText(`${char}/2`, canvasCenterX + 10, canvasCenterY * 0.6)
    ctx.fillText(`-${char}/2`, canvasCenterX + 10, canvasCenterY * 1.4)

    ctx.fillText("X", canvasCenterX * 1.9, canvasCenterY - 10)
    ctx.fillText("Y", canvasCenterX + 10, canvasCenterY * 0.1)
}

function redraw(char) {
    r = char
    drawCanvas(+char);
    markUp(char);
}

const dotCanvas = document.getElementById("working-area" )
dotCanvas.onclick = function(mouse) {
    if (r != "" && r!="R") {

        let mouseX = mouse.offsetX;
        let mouseY = mouse.offsetY ;

        let currentX = (mouseX - canvasCenterX) / (canvasCenterX - canvasCenterX * 0.2) * +r;
        let currentY = (canvasCenterY  - mouseY) / (canvasCenterY  - canvasCenterY  * 0.2) * +r;

        console.log(currentX)
        document.getElementById("form:x-changing-parameter").setAttribute("value", currentX);
        document.getElementById("form:y-changing-parameter").setAttribute("value", currentY);
        // $('#form').submit();
        // drawPoint();
        $('[id="form:submit"]').click();

    } else {
        alert("R value should be declared!");
    }
}

redraw("R");
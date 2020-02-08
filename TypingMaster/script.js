const testWrapper = document.querySelector(".test-wrapper");
const testArea = document.querySelector("#test-area");
const originText = document.querySelector("#origin-text p").innerHTML;
const resetButton = document.querySelector("#reset");
const theTimer = document.querySelector(".timer");


var timer = [0,0,0,0];
var interval;
var timerRunning = false;
// Add leading zero to numbers 9 or below (purely for aesthetics):


// Run a standard minute/second/hundredths timer:
function runTimer(){
  let currentTime = timer[0]+":"+timer[1]+":"+timer[2];
  theTimer.innerHTML = currentTime;
  timer[3]++;
  timer[0] = Math.floor((timer[3]/100)/60);
  timer[1] = Math.floor((timer[3]/100) - (timer[0] * 60));
  timer[2] = Math.floor(timer[3] - timer[1]*100 - timer[0]*6000);
}

// Match the text entered with the provided text on the page:
function spellCheck(){
  let txtEntered = testArea.value;
  let origintxtMatch = originText.substring(0,txtEntered.length);
  if(txtEntered == originText){
    clearInterval(interval);
    testWrapper.style.borderColor = "#429890";
  }else{
    if(txtEntered == origintxtMatch){
      testWrapper.style.borderColor = "#65CCf3";
    }else{
      testWrapper.style.borderColor = "#E95D0f";
    }
  }
  console.log(txtEntered);
}


// Start the timer:
function start(){
  let txtEnteredLength = testArea.value.length;
  if(txtEnteredLength === 0 && !timerRunning){
     timerRunning = true;
     interval =  setInterval(runTimer,10);
  }
  console.log(txtEnteredLength);
}


// Reset everything:
function reset(){
  clearInterval(interval);
  interval = null;
  timer = [0,0,0,0];
  timerRunning = false;
  testArea.value = "";
  theTimer.innerHTML = "00:00:00";
  testWrapper.style.borderColor = "grey";
  console.log("Reset has been pressed.");
}


// Event listeners for keyboard input and the reset button:
testArea.addEventListener("keypress",start,false);
testArea.addEventListener("keyup",spellCheck,false);
resetButton.addEventListener("click",reset,false);

let x1=false,x2=false;
let c;
function cimage1(image) {
    c=image.src;
    console.log(c);
    var n=image.getAttribute('name');
    image.src = `img/${n}`;
        ebutton1();
}
function cimage2(image) {
    var n=image.getAttribute('name');
    image.src = `img/${n}`;
    ebutton2();
}
function ebutton1() {
    const p = document.getElementsByClassName("ii1");
    let pp = false;
    for (let i = 0; i < p.length; i++) {
    
        if (p[i].src==c) {
            console.log(p[i].src);
            pp = true;
        }
    }

    console.log(pp);
    if (pp == false)
        document.getElementById("g").disabled = false;
}
function ebutton2() {
    const p1 = document.getElementsByClassName("ii2");
    let pp1 = false;
    for (let i = 0; i < p1.length; i++) {

        if (p1[i].src == c) {
            console.log(p1[i].src);
            pp1 = true;
        }
    }
    console.log(pp1);
    if (pp1 == false)
        document.getElementById("gg").disabled = false;
}
function disphigh1()
{   var x=document.getElementById("score1").getAttribute('name');
     document.getElementById("score1").innerHTML="<div class='jss'>Highest Card </div>"+"<div class='jss'> Point Scored: "+`${x}`+"</div>";
    var n=document.getElementById("hig1").getAttribute('name');
    document.getElementById("hig1").innerHTML="<img src='img/"+`${n}`+"'>";
    x1=true;
    edeclare();
}
function disphigh2()
{ var x=document.getElementById("score2").getAttribute('name');
document.getElementById("score2").innerHTML="<div class='jss' style='text-align: left margin:1%;'>Highest Card </div>"+"<div class='jss' style='text-align: right margin:1%;'> Point Scored: "+`${x}`+"</div>";
    var n=document.getElementById("hig2").getAttribute('name');
document.getElementById("hig2").innerHTML="<img src='img/"+`${n}`+"'>";
    x2=true;
    edeclare();
}
function edeclare()
{
       if(x1==true && x2==true)
       document.getElementById("win").disabled = false;
}
function winner()
{ var x=document.getElementById("winner1").getAttribute('name');
var y=document.getElementById("winner1").getAttribute('value');
    document.getElementById("winner1").innerHTML="<pre>!!! Congratulations "+`${x}`+" is the Winner & Point Scored is "+`${y}`+"</pre>";
}


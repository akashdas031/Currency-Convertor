let base="http://localhost:8855/currency/v1/convert";
let dropdowns=document.querySelectorAll(".fromd select");
let btn=document.querySelector("form button");
let message=document.querySelector(".msg p");

window.addEventListener("load",()=>{
  exchangeRateVal();
})
for(let select of dropdowns){
  for(currCode in countryList){
    let newElement=document.createElement("option");
    newElement.innerText=currCode;
    newElement.value=currCode;
    if(select.name==="from" && currCode=="USD"){
      newElement.selected="selected";
    }
    if(select.name==="to" && currCode=="INR"){
      newElement.selected="selected";
    }
    select.append(newElement);
  }
  select.addEventListener("change",(evt)=>{
       updateFlag(evt.target);
  })
}
const updateFlag=(elem)=>{
    let currCode=elem.value;
    let countryCode=countryList[currCode];
    let im=elem.parentElement.querySelector("img");
    let newSrc=`https://flagsapi.com/${countryCode}/flat/64.png`;
    im.src=newSrc;
}

btn.addEventListener("click", (evt)=>{

  evt.preventDefault();
  exchangeRateVal();
 })
 const exchangeRateVal=async ()=>{
  let inp=document.querySelector(".amount input");
  let amount=inp.value;
  if(amount==="" || amount <= 0 ){
    amount=1;
    inp.value="1";
  }
  let from=dropdowns[0].value;
  let to =dropdowns[1].value;
  let reqObj={
    from: from,
    to: to,
    amount: amount
  }
  
  let response=await fetch(base,{
    method: 'POST',
    headers: {
       'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(reqObj)
  });
  let data= await response.json();
  let exchangeRate=data.rate;
  message.innerText=`${amount} ${from} = ${exchangeRate} ${to}`;
  

 }

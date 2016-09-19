//if (window.console) {
//  console.log("Welcome to your Play application's JavaScript!");
//}
 function SetPort_onclick()
  {
  	var str;
  	SynIDCard1.Port = document.all['Port'].value
  	document.all['RETSTR'].value="端口设置为"+SynIDCard1.Port;

  }
  function Init_onclick()
  {
  	var str=SynIDCard1.Init();
  	document.all['RETSTR'].value="初始化结果"+str;
  }
  function ReadCard_onclick()
  {
  	document.all['RETSTR'].value=SynIDCard1.ReadCard();
   	document.all['NameA'].value=SynIDCard1.NameA;
   	document.all['Name2'].value=SynIDCard1.NameL;
   	document.all['Sex'].value=SynIDCard1.Sex;
   	document.all['Sex2'].value=SynIDCard1.SexL;
   	document.all['Nation'].value=SynIDCard1.Nation;
   	document.all['Nation2'].value=SynIDCard1.NationL;
   	document.all['Born'].value=SynIDCard1.Born;
   	document.all['Born2'].value=SynIDCard1.BornL;
   	document.all['Address'].value=SynIDCard1.Address;
   	document.all['CardNo'].value=SynIDCard1.CardNo;
   	document.all['Activity'].value=SynIDCard1.Activity;
   	document.all['Activity2'].value=SynIDCard1.ActivityL;
   	document.all['Police'].value=SynIDCard1.Police;
   	document.all['PhotoName'].value=SynIDCard1.PhotoName;
  }
  function ReadSAMID_onclick()
  {
  	var str=SynIDCard1.ReadSAMID();
  	document.all['RETSTR'].value=str;

  }


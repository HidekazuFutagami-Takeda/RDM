var objOpenedNaviMenu = null;

var strNaviBarID;		// NavigationBar DIV ID

var strNaviMenuID;	   // + n	MenuItemTitle TD ID
var strNaviMenuClass;	//		MenuItemTitle TD and A Class
var strNaviLinkID;	  // + n	MenuItemTitle A ID 

var strMenuBlockID;	 // + n	 MenuItemFloating DIV ID
             //		MenuItemFolating DIV Class --> Don't use this script, but css for desgin
var strMenuItemClass;	 //		SubItemTitle DIV and A Class

// Navigation System Start Method
function startNaviMenu(NaviBarID, NaviMenuID, NaviMenuClass, NaviLinkID, MenuBlockID, MenuItemClass){

// modify start 2011/03/28 T.Oonisi J11-0013 iPadレイアウト変更対応
  if(!getNavigatorMemuIpad()){

    // init properties
    strNaviBarID	 = NaviBarID;
    strNaviMenuID	 = NaviMenuID;
    strNaviMenuClass = NaviMenuClass;
    strNaviLinkID	 = NaviLinkID;
    strMenuBlockID	 = MenuBlockID;
    strMenuItemClass = MenuItemClass; 

    // event handling
    if(IE4 || OP6){ 
      document.onmouseover = viewNaviMenuIEandOpera; 
    
    }else if(NN6){
      window.addEventListener("mouseover", viewNaviMenuN6, true);
    }
  
  }
// modify end   2011/03/28 T.Oonisi J11-0013 iPadレイアウト変更対応
}

// Common Get Object from ID Name
function getObjectFromID(strIDName){
  if( IE4 ){
    return document.all[strIDName];
  }else{
    return document.getElementById(strIDName);
  }
}

// Common Open Menu
function viewNaviMenuCommon(objEvent){
  
  if(!objEvent){ return;}
  
  if(objEvent.className == "mainMenuScroll"){ return;}

  objPosition = getObjectFromID(strNaviBarID);
  if( objEvent.className == strNaviMenuClass ){

    closeNaviMenu();
    var strThisID = objEvent.id;
    if( strThisID.indexOf(strNaviLinkID) >= 0 ){ 
      strThisID = strThisID.replace(strNaviLinkID, strNaviMenuID)
    }

    objItem = getObjectFromID( strThisID );
    objOpenedNaviMenu = getObjectFromID( strThisID.replace(strNaviMenuID, strMenuBlockID) );

    //objOpenedNaviMenu.style.top  = objItem.offsetTop  + objPosition.offsetTop + objPosition.offsetHeight + "px";
    
    
    objOpenedNaviMenu.style.display = "block";
    
    //カーソル位置を取得
    var x = event.clientX+document.body.scrollLeft - 10;
    var y = event.clientY+document.body.scrollTop - 7;

    //ポップメニュー表示位置判定ロジック START

    var docH = document.body.clientHeight; //ブラウザ縦
    var popH = objOpenedNaviMenu.offsetHeight;//pop縦
    
    //divのスクロール移動位置を取得
    var ev = document.all.mainMenu.scrollTop;
    
    //オブジェクトサイズ
    var objSize = document.all.mainMenu.offsetHeight;
    var eventY = Event.pointerY(window.event);
    // add start 2010/09/07 T.Oonisi B10-0247 メニューDB化対応
    document.images["img" + objOpenedNaviMenu.id].style.marginTop = "3px";
    // add end   2010/09/07 T.Oonisi B10-0247 メニューDB化対応
    document.images["img" + objOpenedNaviMenu.id].src = "img/menuLinkIcon3.png";
    
    
    /*
    if(docH > y + popH){
      objOpenedNaviMenu.style.top  = y
    }else{
      objOpenedNaviMenu.style.top  = y - popH + 7;
    }*/
    
    if(docH > ((eventY - mainMenuTop) + popH) && !(objSize < ((eventY - mainMenuTop) + popH)) ){
      objOpenedNaviMenu.style.posTop  = ((eventY - mainMenuTop) + ev) - mainSubMenuTop;
    }else if( !(docH > ((eventY - mainMenuTop) + popH)) && objSize < ((eventY - mainMenuTop) + popH)){
      objOpenedNaviMenu.style.posTop = (((eventY - popH) + ev) - mainMenuTop) - (mainSubMenuTop-7);
    }else{
      objOpenedNaviMenu.style.posTop = (((eventY - popH) + ev) - mainMenuTop) - (mainSubMenuTop-7);
    }


    //ポップメニュー表示位置判定ロジック END


// update start k.fujii 左位置は固定になった
//		objOpenedNaviMenu.style.left = x;
// update 2005/06/03 k.fujii 小さいフォント対応
//		objOpenedNaviMenu.style.left = 70;   //大きいフォント用
// modify start 2010/09/07 T.Oonisi B10-0247 メニューDB化対応
    //objOpenedNaviMenu.style.left = 65;   //小さいフォント用
    objOpenedNaviMenu.style.left = 43;
// modify end   2010/09/07 T.Oonisi B10-0247 メニューDB化対応

    //objOpenedNaviMenu.style.top  = objItem.offsetTop  + objPosition.offsetTop;
    //objOpenedNaviMenu.style.left = objItem.offsetLeft + objPosition.offsetLeft + "px" + 100;
    //objOpenedNaviMenu.style.left = 100;


    //objOpenedNaviMenu.style.visibility = "visible";
  
  }else if( objOpenedNaviMenu != null ){

    if( NN6 ){
      if( objEvent.id.indexOf( strMenuBlockID ) >= 0 ){ return; }
      if( objEvent.className == strMenuItemClass ){ return; }
    }else{
      if( objOpenedNaviMenu.contains(objEvent) == true
        || objPosition.contains(objEvent) == true){ return; }
    }
    closeNaviMenu();
  }

}

// Internet Explorer 4,5,6 and Opera 6,7 Event Handler
function viewNaviMenuIEandOpera(){
  viewNaviMenuCommon( window.event.srcElement );
}

// Netscape 6,7 Event Handler
function viewNaviMenuN6(eventMouseOver){
  viewNaviMenuCommon( eventMouseOver.target );
}

// Common Close Menu
function closeNaviMenu(){
  if(objOpenedNaviMenu != null){
    // add start 2010/09/07 T.Oonisi B10-0247 メニューDB化対応
    document.images["img" + objOpenedNaviMenu.id].style.marginTop = "3px";
    // add end   2010/09/07 T.Oonisi B10-0247 メニューDB化対応
    document.images["img" + objOpenedNaviMenu.id].src = "img/menuLinkIcon2.png";
    //objOpenedNaviMenu.style.visibility = "hidden";
    objOpenedNaviMenu.style.display = "none";
  }
  objOpenedNaviMenu = null
}

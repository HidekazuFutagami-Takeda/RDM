<%@ page 
  language="java"
  import="java.util.*,java.text.*,jp.co.takeda.rdm.util.AppConstant"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  contentType="text/html;charset=UTF-8"
%>
<script type="text/javascript">
<!--
var COMM_HOMELINK   = "<%=AppConstant.HOMEPAGE_URL%>/maps/servlet/control?screenId=Menu&functionId=ViewInit";

function _errorClose(){
    if(window.parent.frames.length > 0){
        parent.location.href = COMM_HOMELINK;
    }else{
        if (opener == null){
            self.location.href = COMM_HOMELINK;
        }else{
            if( opener.parent.frames.length > 0 ){
                opener.top.location.href = COMM_HOMELINK;
                self.window.close();
                opener.focus();
            }
            else{
                opener.location.href = COMM_HOMELINK;
                self.window.close();
                opener.focus();
            }
        }
    }
}
//-->
</script>

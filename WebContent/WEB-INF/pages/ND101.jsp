<%--
/**
 * <pre>
 *  医師検索のJSP
 * </pre>
 * @since 1.0
 * @version $Revision: 1.1 $
 * @author SBS 内海
 * @see
 */
--%>
<%@page import="jp.co.takeda.rdm.util.StringUtils"%>
<%@page import="jp.co.takeda.rdm.dto.ND307DTO"%>
<%@page import="jp.co.takeda.rdm.dto.ND101DTO"%>
<%@page import="java.util.List"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="java.util.Enumeration"%>
<%@ page
  language="java"
  import="jp.co.takeda.rdm.util.AppConstant,java.util.ArrayList,java.math.BigDecimal,java.lang.String"
  session="true"
  buffer="8kb"
  autoFlush="true"
  isThreadSafe="true"
  contentType="text/html;charset=UTF-8"

%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>ND101_医療機関への異動</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
<link href="css/common2.css" rel="Stylesheet" type="text/css" />
<link href="css/jgiKanren.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="js/jkrSosStatus.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>

<script type="text/javascript" src="js/ND101.js"></script>
<script type="text/javascript" src="js/catTkCityCombo.js"></script>
<script type="text/javascript" src="js/imtInsInputCategores.js"></script>
<script type="text/javascript" src="js/jgiKanren.js"></script>
<script type="text/javascript" src="js/rdmCatSosExpand.js"></script>
<script type="text/javascript" src="js/jkrMenu.js"></script>
</head>
<body class="comPage" onUnload="JavaScript:jmrUnLoad();" onLoad="JavaScript:comSetFormWindowInfo();"/>

    <s:form name="fm1" theme="simple" onSubmit="JavaScript:return false;" >
          <s:hidden name="screenId" value="ND101"/>
          <s:hidden name="functionId" value="Register"/>
          <s:hidden id="pageFlag" name="pageFlag" />
          <s:hidden id="mrAdminFlg" name="mrAdminFlg" />

          <s:hidden name="preScreenId" id="preScreenId"/>
          <s:hidden name="reqYmdhms"/>
          <s:hidden name="reqBrCode"/>
          <s:hidden name="reqDistCode"/>
          <s:hidden name="updShaYmd"/>
          <s:hidden name="postInsNo"/>
          <s:hidden name="postUltInsNo"/>
          <s:hidden name="postDeptCode"/>
          <s:hidden name="postDeptKn"/>
          <s:hidden name="preInsNo"/>
          <s:hidden name="preUltInsNo"/>
          <s:hidden name="preDeptCode"/>
          <s:hidden name="preDeptKn"/>
          <s:hidden name="preTitleCode"/>
          <s:hidden name="preJobForm"/>
          <s:hidden name="preDcc"/>
          <s:hidden name="preUnivPosCode"/>
          <s:hidden name="ultDocNo"/>
          <s:hidden name="aprComment"/>
          <s:hidden name="docNo"/>
          <s:hidden name="insNo"/>
          <s:hidden name="reqId"/>
          <s:hidden name="today" id="today" value=""/>
          <s:hidden name="preHoInsType"/>
          <s:hidden name="postHoInsType"/>


          <s:hidden name="reqShz"/>
          <s:hidden name="reqStsNm"/>
          <s:hidden name="reqJgiName"/>
          <s:hidden name="docKanj"/>
          <s:hidden name="preInsAbbrName"/>
          <s:hidden name="preDeptKj"/>
          <s:hidden name="titlePreTitleKj"/>
          <s:hidden name="kmuPreCodeKanj"/>
          <s:hidden name="yakushinPreCodeKanj"/>
          <s:hidden name="univPreTitleKj"/>
          <s:hidden name="tekiyoDay"/>
          <s:hidden name="trnKbn"/>
          <s:hidden name="reqFlg"/>
          <s:hidden name="inputFlg"/>
          <s:hidden name="reqCommentFlg"/>
          <s:hidden name="MovemedEditFlg"/>



          <s:hidden name="reqDestBtnFlg"/>

          <s:hidden name="tempReqBtnFlg" id="tempReqBtnFlg" value="0"/>
          <s:hidden name="reqBtnFlg" id="reqBtnFlg" value="0"/>


		<table id="formTable00" border="0" cellpadding="2" cellspacing="0"
			width="600px">
			<tbody>
				<s:if test="msgStr != null">
					<tr>
						<td><nobr>
								<s:property value="msgStr.replaceAll('\\n', '<br />')"
									escape="false" />
							</nobr></td>
					</tr>
				</s:if>
			</tbody>
		</table>

		<table class="comPortalTable" align="center">
              <tr>
                  <td>申請情報</td>
                  <td>申請ID</td>
                  <td><s:label key="reqId"/></td>
              </tr>
              <tr>
                  <td></td>
                  <td>申請者所属</td>
                  <td><s:label key="reqShz"/></td>
                  <td>申請ステータス</td>
                  <td><s:label key="reqStsNm"/></td>
              </tr>
              <tr>
                  <td></td>
                  <td>申請者氏名</td>
                  <td><s:label key="reqJgiName"/></td>
                  <td>申請日時</td>
                  <td><s:label key="reqYmdhms"/></td>
              </tr>
              <tr style="border_top: 4px solid #fff;">
                  <td>変更前</td>
              </tr>
              <tr>
                  <td></td>
                  <td>医師・コメディカル名</td>
                  <td><s:label key="docKanj"/></td>
              </tr>
              <tr>
                  <td></td>
                  <td>所属施設</td>
                  <td><s:label key="preInsAbbrName"/></td>
                  <td>所属部科</td>
                  <td><s:label key="preDeptKj"/></td>
              </tr>
              <tr>
                  <td></td>
                  <td>役職</td>
                  <td><s:label key="titlePreTitleKj"/></td>
                  <td>勤務形態</td>
                  <td><s:label key="kmuPreCodeKanj"/></td>
              </tr>
              <tr>
                  <td></td>
                  <td>薬審メンバー区分</td>
                  <td><s:label key="yakushinPreCodeKanj"/></td>
                  <td>大学職位</td>
                  <td><s:label key="univPreTitleKj"/></td>
              </tr>
          <s:if test='(trnKbn == "42" || movemedEditFlg == "0")'>
              <tr>
                  <td></td>
                  <td>異動区分</td>
                  <td>医療機関</td>
              </tr>
          </s:if>
              <tr style="border_top: 4px solid #fff;">
                  <td>変更後</td>
              </tr>
              <s:if test='(trnKbn == "42" || movemedEditFlg == "0")'>
	              <tr>
	                  <td>
	                  </td>
	                  <td>異動先施設<span style="color: red;">*</span></td>
	                  <td><s:textfield name="abbrName" size="17" maxlength="17" cssStyle="background-color:#D4D0C8;" readonly="true"/><a class="comMiniLink" onclick="jimClear(abbrName)" style="color:lightgray">clear</a>&nbsp;</td>
	              </tr>
	              <tr>
	                  <td></td>
	                  <td>異動先所属部科<span style="color: red;">*</span></td>
	                  <td><s:textfield name="shozokubukaName" size="17" maxlength="17" cssStyle="background-color:#D4D0C8;" readonly="true"/><a class="comMiniLink" onclick="jimClear(shozokubukaName)" style="color:lightgray">clear</a>&nbsp;</td>
	              </tr>
              </s:if>
              <s:else>
	              <tr>
	                  <td></td>
	                  <td>所属部科<span style="color: red;">*</span></td>
	                  <td><s:textfield name="shozokubukaName" size="17" maxlength="17" cssStyle="background-color:#D4D0C8;" readonly="true"/><a class="comMiniLink" onclick="jimClear(shozokubukaName)" style="color:lightgray">clear</a>&nbsp;</td>
	              </tr>
              </s:else>
              <tr>
                  <td></td>
                  <td>役職<span style="color: red;">*</span></td>
                  <td class="comPortalControlItem" style="text-align:left;">
                  <s:if test='inputFlg == 1'>
                      <s:select id="yakushoku" name="yakushoku" cssStyle="width:100pt" list ="yakushokuCombo"/>
                  </s:if>
                  <s:elseif test="inputFlg == 0">
                      <select disabled style="width:100pt">
                          <option><s:label key="titlePostTitleKj"/></option>
                      </select>
                  </s:elseif>
                  </td>
                  <td>勤務形態</td>
                  <td class="comPortalControlItem" style="text-align:left;">
					<s:if test='inputFlg == 1'>
						<s:select id="jobForm" name="jobForm" cssStyle="width:100pt" list="jobFormCombo" />
					</s:if>
					<s:elseif test="inputFlg == 0">
                      <select disabled style="width:100pt">
                          <option><s:label key="kmuPostCodeKanj"/></option>
                      </select>
					</s:elseif>
				</td>
              </tr>
              <tr>
                  <td></td>
                  <td>薬審メンバー区分</td>
                  <td class="comPortalControlItem" style="text-align:left;">
                  <s:if test='inputFlg == 1'>
                      <s:select id="dcc" name="dcc" cssStyle="width:100pt" list ="dccCombo"/>
                  </s:if>
                  <s:elseif test="inputFlg == 0">
                      <select disabled style="width:100pt">
                          <option><s:label key="yakushinPostCodeKanj"/></option>
                      </select>
                  </s:elseif>
                  </td>
                  <td>大学職位</td>
                  <td class="comPortalControlItem" style="text-align:left;">
				<s:if test='(trnKbn == "42" || movemedEditFlg == 0)'>

					<s:if test='inputFlg == 1 && postHoInsType == 1'>
						<s:select id="digakuShokui" name="digakuShokui"
							cssStyle="width:100pt" list="digakuShokuiCombo" />
					</s:if>
					<s:else>
						<select disabled style="width: 100pt">
							<option><s:label key="univPostTitleKj" /></option>
						</select>
					</s:else>
				</s:if> <s:else>
					<s:if test='inputFlg == 1 && preHoInsType == 1'>
						<s:select id="digakuShokui" name="digakuShokui"
							cssStyle="width:100pt" list="digakuShokuiCombo" />
					</s:if>
					<s:else>
						<select disabled style="width: 100pt">
							<option><s:label key="univPostTitleKj" /></option>
						</select>
					</s:else>
				</s:else>
			</td>
              </tr>
              <tr>
                  <td></td>
                  <td>適用日</td>
                  <td>
                      <s:if test='inputFlg == 1'>
                          <input id="tekiyoYmd" type="date" name="selectDay" value="${tekiyoDay}" pattern="yyyy-MM-dd" style="width:100pt" tabindex="-1"/>
                      </s:if>
                      <s:if test='inputFlg == 0'>
                          <input type="date" name="selectDay" value="${tekiyoDay}" pattern="yyyy-MM-dd" style="width:100pt" tabindex="-1" disabled />
                      </s:if>
                  </td>
              </tr>
          </table>
          <table class="comPortalTable" align="center">
              <tr>
                  <td>申請コメント</td>
              </tr>
          </table>
          <table class="comPortalTable" align="center">
              <tr>
                  <td>
                      <s:if test='reqCommentFlg == 1'>
                          <s:textarea label="ReqComment" name="reqComment" style="width: 60vw; resize: none;" rows="3"/>
                      </s:if>
                      <s:elseif test='reqCommentFlg == 0'>
                          <s:textarea label="ReqComment" name="reqComment" style="width: 60vw; resize: none; background-color:#D4D0C8" rows="3" readonly="true"/>
                      </s:elseif>
                  </td>
              </tr>
          </table>
          <table class="comPortalTable" style="margin-top:3pt;margin-bottom:1pt; "align="center">
              <tr>
                  <td><input class="comButton" type="button" name="button1" id="button1" value="戻る" onClick="JavaScript:backBtn();return false;"/></td>
              <s:if test='reqDestBtnFlg == 1'>
                  <td align="right"><input class="comButton" type="button" name="button2" id="button2" value="申請破棄１" onClick="JavaScript:reqCancelBtn();return false;"/></td>
              </s:if>
              <s:elseif test='reqDestBtnFlg == 0'>
                  <td align="right"><input class="comButton" type="button" name="button3" id="button3" value="申請破棄２" onClick="JavaScript:reqCancelBtn();return false;"disabled/></td>
              </s:elseif>
              <s:if test='tempReqBtnFlg == 1'>
                  <td><input class="comButton" type="button" name="button4" id="button4" value="一時保存" onClick="JavaScript:submitBtn('0');return false;"/></td>
              </s:if>
              <s:elseif test='tempReqBtnFlg == 0'>
                  <td><input class="comButton" type="button" name="button5" id="button5" value="一時保存" onClick="JavaScript:submitBtn('0');return false;" disabled/></td>
              </s:elseif>
              <s:if test='reqBtnFlg == 1'>
                  <td align="right"><input class="comButton" type="button" name="button6" id="button6" value="申請画面へ" onClick="JavaScript:submitBtn('1');return false;"/></td>
              </s:if>
              <s:elseif test='reqBtnFlg == 0'>
                  <td align="right" style="width:130px"></td>
              </s:elseif>
              </tr>
          </table>
    </s:form>
    <script>
	document.getElementById('tekiyoYmd').addEventListener('keydown',function(event) {
		if(event.key === 'Backspace' || event.key === 'Delete') {
			event.preventDefault();
		}
	});
    </script>
</body>
</html>

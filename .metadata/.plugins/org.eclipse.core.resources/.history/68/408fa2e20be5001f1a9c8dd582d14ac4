/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.dto.NC207DTO;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;
import jp.co.takeda.rdm.entity.join.MRdmHcpPubInstitutionEntity;
import jp.co.takeda.rdm.entity.join.SelectComboListEntity;

import jp.co.takeda.rdm.util.AppConstant;
import jp.co.takeda.rdm.util.DateUtils;
import jp.co.takeda.rdm.util.RdmConstantsData;
import jp.co.takeda.rdm.util.StringUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviceクラス（NC207)
 * @generated
 */
@Named
public class NC207Service extends BaseService {

	/**
	 * ログインスタンス
	 * @generated
	 */
	private static Log log = LogFactory.getLog(NC207Service.class);

	//20150303 ST-B-367対応 HISOL鈴木 ADD START
	/**
	 * 共通処理Serviceオブジェクト
	 *   新組織名称(変更前)取得処理
	 */
	@javax.inject.Inject
	private CommonControlService commonControlService;

	/**
	 * イベント処理
	 * @param indto NC207DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO init(NC207DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
//		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

		// DropDownList作成
		createCombo(indto);

		// END UOC
		return outdto;
	}

	/**
	 * コンボ作成
	 * @param indto NC207DTO
	 * @return なし
	 * @customizable
	 */
	private void createCombo(NC207DTO indto){
		//1-2-1			分類区分
		//		コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//		コード名＝CLASS_CATEGORY（分類区分）
		//		削除フラグ=0
		SelectComboListEntity inEntityCmb = new SelectComboListEntity();
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_CLASS_CATEGORY);
		List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapClassCategoryCd = new LinkedHashMap<String, String>();
		mapClassCategoryCd.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapClassCategoryCd.put(outEntity.getValue(), outEntity.getValueKanji());
		}
		indto.setClassCategoryCdCombo(mapClassCategoryCd);

		//1-2-3			公的機関役職
		//		コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//		コード名＝POSITION_CODE（所属役職）
		//		削除フラグ=0
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_POSITION_CODE);
		outMainList.clear();
		outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapPositionCode = new LinkedHashMap<String, String>();
		mapPositionCode.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapPositionCode.put(outEntity.getValue(), outEntity.getValueKanji());
		}
		indto.setPubInstPositionCdCombo(mapPositionCode);

		//1-2-2			公的機関
		//		医師_公的機関マスタから下記条件で公的機関コード：公的機関名を並び順昇順に取得しドロップダウンリストを作成する
		//		削除フラグ=0
		MRdmHcpPubInstitutionEntity inEntityHpiCmb = new MRdmHcpPubInstitutionEntity();
		inEntityHpiCmb.setDelFlg(0);
		List<MRdmHcpPubInstitutionEntity> outMainHpiList = dao.selectByValue(inEntityHpiCmb);
		LinkedHashMap<String, String> mapPubInstitutionCd = new LinkedHashMap<String, String>();
		mapPubInstitutionCd.put("", "--なし--");
		for (MRdmHcpPubInstitutionEntity outEntity : outMainHpiList) {
			mapPubInstitutionCd.put(outEntity.getPubInstitutionCd(), outEntity.getPubInstitutionNm());
		}
		indto.setPubInstitutionCdCombo(mapPubInstitutionCd);

		//各種年月日
		//下記で作成する                          空白を選択可能とし、取得値が無い場合は空白を初期値として選択する
		//            年      現在日付の年+1年～－100年
		//            月      01～12
		//            日      01～31
		MRdmComCalUsrEntity inEntityYearCmb = new MRdmComCalUsrEntity();
		inEntityYearCmb.setToday("1");
		MRdmComCalUsrEntity outCalUsr = dao.selectByValue(inEntityYearCmb).get(0);
		int yearInt = Integer.parseInt(outCalUsr.getCalYear());
		LinkedHashMap<String, String> mapYear = new LinkedHashMap<String, String>();
		mapYear.put("", "");
		for (int i = 0; i < 101; i++) {
			String yearStr = Integer.toString(yearInt + 1 - i);
			mapYear.put(yearStr, yearStr);
		}

		LinkedHashMap<String, String> mapMonth = new LinkedHashMap<String, String>();
		mapMonth.put("", "");
		for (int i = 0; i < 12; i++) {
			String monthStr = String.format("%02d", (i+1));
			mapMonth.put(monthStr, monthStr);
		}

		LinkedHashMap<String, String> mapDay = new LinkedHashMap<String, String>();
		mapDay.put("", "");
		for (int i = 0; i < 31; i++) {
			String dayStr = String.format("%02d", (i+1));
			mapDay.put(dayStr, dayStr);
		}

		indto.setPubInstStYYYYCombo(mapYear); // 公的機関開始年月日(年)
		indto.setPubInstStMMCombo(mapMonth); // 公的機関開始年月日(月)
		indto.setPubInstStDDCombo(mapDay); // 公的機関開始年月日(日)
		indto.setPubInstEdYYYYCombo(mapYear); // 公的機関終了年月日(年)
		indto.setPubInstEdMMCombo(mapMonth); // 公的機関終了年月日(月)
		indto.setPubInstEdDDCombo(mapDay); // 公的機関終了年月日(日)
		indto.setPubInstposStYYYYCombo(mapYear); // 公的機関役職開始年月日(年)
		indto.setPubInstposStMMCombo(mapMonth); // 公的機関役職開始年月日(月)
		indto.setPubInstposStDDCombo(mapDay); // 公的機関役職開始年月日(日)
		indto.setPubInstposEdYYYYCombo(mapYear); // 公的機関役職終了年月日(年)
		indto.setPubInstposEdMMCombo(mapMonth); // 公的機関役職終了年月日(月)
		indto.setPubInstposEdDDCombo(mapDay); // 公的機関役職終了年月日(日)

	}
	/**
	 * イベント処理
	 * @param indto NC207DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO register(NC207DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
		// DropDownList作成
		createCombo(indto);
		// START UOC
			// チェック処理
		if(checkInput(loginInfo,indto)) {//エラーあり
			indto.setReturnFlg("0");
			return outdto;
		}

		LinkedHashMap<String,String> classCategoryCdCombo = indto.getClassCategoryCdCombo();
		indto.setClassCategoryNmPop(classCategoryCdCombo.get(indto.getClassCategoryCdPop()));

		LinkedHashMap<String,String> pubInstitutionCdCombo = indto.getPubInstitutionCdCombo();
		indto.setPubInstitutionNmPop(pubInstitutionCdCombo.get(indto.getPubInstitutionCdPop()));

		LinkedHashMap<String,String> pubInstPositionCdCombo = indto.getPubInstPositionCdCombo();
		indto.setPubInstPositionNmPop(pubInstPositionCdCombo.get(indto.getPubInstPositionCdPop()));

		indto.setReturnFlg("1");
		// END UOC
		return outdto;
	}

	/*
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkInput(LoginInfo loginInfo, NC207DTO indto) {
		boolean errChk = false;
		boolean dateErrChk = false;
		String msgStr = "";
		String tmpMsgStr = "";
		//	１：必須入力チェック
		//	項目
		//	分類区分,公的機関コード
		if(StringUtils.isEmpty(indto.getClassCategoryCdPop())) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
			tmpMsgStr.replace("項目名", "分類区分");
			msgStr = msgStr + tmpMsgStr + "\n";
		}

		if(StringUtils.isEmpty(indto.getPubInstitutionCdPop())) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
			tmpMsgStr.replace("項目名", "公的機関");
			msgStr = msgStr + tmpMsgStr + "\n";
		}

		//		６：範囲チェック
		//		項目                                チェック内容
		//		各種年月日項目	各種年月日項目の「月」「日」の組み合わせが存在しない日付であった場合 例：２月３０日　など
		//W022	有効な年月日を入力してください。（項目名）
		//公的機関開始年月日
		if(!StringUtils.isEmpty(indto.getPubInstStYYYYPop()) || !StringUtils.isEmpty(indto.getPubInstStMMPop()) || !StringUtils.isEmpty(indto.getPubInstStDDPop())) {
			if(!DateUtils.isDate(indto.getPubInstStYYYYPop() + indto.getPubInstStMMPop() + indto.getPubInstStDDPop())) {
				errChk = true;
				dateErrChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W022);//有効な年月日を入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "公的機関開始年月日");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//公的機関終了年月日
		if(!StringUtils.isEmpty(indto.getPubInstEdYYYYPop()) || !StringUtils.isEmpty(indto.getPubInstEdMMPop()) || !StringUtils.isEmpty(indto.getPubInstEdDDPop())) {
			if(!DateUtils.isDate(indto.getPubInstEdYYYYPop() + indto.getPubInstEdMMPop() + indto.getPubInstEdDDPop())) {
				errChk = true;
				dateErrChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W022);//有効な年月日を入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "公的機関終了年月日");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//公的機関役職開始年月日
		if(!StringUtils.isEmpty(indto.getPubInstposStYYYYPop()) || !StringUtils.isEmpty(indto.getPubInstposStMMPop()) || !StringUtils.isEmpty(indto.getPubInstposStDDPop())) {
			if(!DateUtils.isDate(indto.getPubInstposStYYYYPop() + indto.getPubInstposStMMPop() + indto.getPubInstposStDDPop())) {
				errChk = true;
				dateErrChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W022);//有効な年月日を入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "公的機関役職開始年月日");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//公的機関役職終了年月日
		if(!StringUtils.isEmpty(indto.getPubInstposEdYYYYPop()) || !StringUtils.isEmpty(indto.getPubInstposEdMMPop()) || !StringUtils.isEmpty(indto.getPubInstposEdDDPop())) {
			if(!DateUtils.isDate(indto.getPubInstposEdYYYYPop() + indto.getPubInstposEdMMPop() + indto.getPubInstposEdDDPop())) {
				errChk = true;
				dateErrChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W022);//有効な年月日を入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "公的機関役職終了年月日");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}

		if(!dateErrChk) {//日付は有効な値または未設定である
			//		７：整合性チェック
			//      各種年月日項目	各種年月日項の開始・終了のが不適切（開始日＞終了日）な場合
			//公的機関開始年月日<公的機関終了年月日
			if((!StringUtils.isEmpty(indto.getPubInstStYYYYPop()) && !StringUtils.isEmpty(indto.getPubInstStMMPop()) && !StringUtils.isEmpty(indto.getPubInstStDDPop()))
					&& (!StringUtils.isEmpty(indto.getPubInstEdYYYYPop()) && !StringUtils.isEmpty(indto.getPubInstEdMMPop()) && !StringUtils.isEmpty(indto.getPubInstEdDDPop()))) {
				if(!DateUtils.compareDate((indto.getPubInstStYYYYPop() + indto.getPubInstStMMPop() + indto.getPubInstStDDPop())
						,(indto.getPubInstEdYYYYPop() + indto.getPubInstEdMMPop() + indto.getPubInstEdDDPop()))){
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W003);//W003	終了日は開始日以降を選択してください。
					msgStr = msgStr + tmpMsgStr +"(公的機関終了年月日)"+ "\n";
				}
			}
			//公的機関役職開始年月日<公的機関役職終了年月日
			if((!StringUtils.isEmpty(indto.getPubInstposStYYYYPop()) && !StringUtils.isEmpty(indto.getPubInstposStMMPop()) && !StringUtils.isEmpty(indto.getPubInstposStDDPop()))
					&& (!StringUtils.isEmpty(indto.getPubInstposEdYYYYPop()) && !StringUtils.isEmpty(indto.getPubInstposEdMMPop()) && !StringUtils.isEmpty(indto.getPubInstposEdDDPop()))) {
				if(!DateUtils.compareDate((indto.getPubInstposStYYYYPop() + indto.getPubInstposStMMPop() + indto.getPubInstposStDDPop())
						,(indto.getPubInstposEdYYYYPop() + indto.getPubInstposEdMMPop() + indto.getPubInstposEdDDPop()))){
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W003);//W003	終了日は開始日以降を選択してください。
					msgStr = msgStr + tmpMsgStr +"(公的機関役職終了年月日)"+ "\n";
				}
			}
		}
		if(errChk) {//エラーありなのでメッセージをセットする
			indto.setMsgStr(msgStr);
		}
		return errChk;
	}

}

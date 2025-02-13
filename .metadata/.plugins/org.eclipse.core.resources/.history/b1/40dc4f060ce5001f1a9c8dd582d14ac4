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
import jp.co.takeda.rdm.dto.NC206DTO;
import jp.co.takeda.rdm.entity.join.MRdmComCalUsrEntity;

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
 * Serviceクラス（NC206)
 * @generated
 */
@Named
public class NC206Service extends BaseService {

	/**
	 * ログインスタンス
	 * @generated
	 */
	private static Log log = LogFactory.getLog(NC206Service.class);

	//20150303 ST-B-367対応 HISOL鈴木 ADD START
	/**
	 * 共通処理Serviceオブジェクト
	 *   新組織名称(変更前)取得処理
	 */
	@javax.inject.Inject
	private CommonControlService commonControlService;

	/**
	 * イベント処理
	 * @param indto NC206DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO init(NC206DTO indto) {
		BaseDTO outdto = indto;
		// START UOC
//		LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();

		// DropDownList作成
		createCombo(indto);

		// END UOC
		return outdto;
	}


//	private void setHcpSocietyData(NC206DTO indto, HcpSocietyData sData) {
//		sData.setMedicalSocietyNm(indto.getMedicalSocietyNmPop());
//		sData.setAdmissionYYYY(indto.getAdmissionYYYYPop());
//		sData.setAdmissionMM(indto.getAdmissionMMPop());
//		sData.setAdmissionDD(indto.getAdmissionDDPop());
//		sData.setQuitYYYY(indto.getQuitYYYYPop());
//		sData.setQuitMM(indto.getQuitMMPop());
//		sData.setQuitDD(indto.getQuitDDPop());
//		sData.setPositionCode(indto.getPositionCodePop());
//		LinkedHashMap<String,String> positionCodeCombo = indto.getPositionCodeCombo();
//		sData.setPositionName(positionCodeCombo.get(indto.getPositionCodePop()));
//		sData.setSocietyPosiStYYYY(indto.getSocietyPosiStYYYYPop());
//		sData.setSocietyPosiStMM(indto.getSocietyPosiStMMPop());
//		sData.setSocietyPosiStDD(indto.getSocietyPosiStDDPop());
//		sData.setSocietyPosiEdYYYY(indto.getSocietyPosiEdYYYYPop());
//		sData.setSocietyPosiEdMM(indto.getSocietyPosiEdMMPop());
//		sData.setSocietyPosiEdDD(indto.getSocietyPosiEdDDPop());
//		sData.setAdvisingDoctorCd(indto.getAdvisingDoctorCdPop());
//		LinkedHashMap<String,String> advisingDoctorCdCombo = indto.getAdvisingDoctorCdCombo();
//		sData.setAdvisingDoctorNm(advisingDoctorCdCombo.get(indto.getAdvisingDoctorCdPop()));
//		sData.setCoachingAcquisiYYYY(indto.getCoachingAcquisiYYYYPop());
//		sData.setCoachingAcquisiMM(indto.getCoachingAcquisiMMPop());
//		sData.setCoachingAcquisiDD(indto.getCoachingAcquisiDDPop());
//		sData.setCoachingStYYYY(indto.getCoachingStYYYYPop());
//		sData.setCoachingStMM(indto.getCoachingStMMPop());
//		sData.setCoachingStDD(indto.getCoachingStDDPop());
//		sData.setCoachingEdYYYY(indto.getCoachingEdYYYYPop());
//		sData.setCoachingEdMM(indto.getCoachingEdMMPop());
//		sData.setCoachingEdDD(indto.getCoachingEdDDPop());
//		sData.setCertifyingPhysicianCd(indto.getCertifyingPhysicianCdPop());
//		LinkedHashMap<String,String> certifyingPhysicianCdCombo = indto.getCertifyingPhysicianCdCombo();
//		sData.setCertifyingPhysicianNm(certifyingPhysicianCdCombo.get(indto.getCertifyingPhysicianCdPop()));
//		sData.setCertifyStYYYY(indto.getCertifyStYYYYPop());
//		sData.setCertifyStMM(indto.getCertifyStMMPop());
//		sData.setCertifyStDD(indto.getCertifyStDDPop());
//		sData.setCertifyEdYYYY(indto.getCertifyEdYYYYPop());
//		sData.setCertifyEdMM(indto.getCertifyEdMMPop());
//		sData.setCertifyEdDD(indto.getCertifyEdDDPop());
//	}

	/**
	 * コンボ作成
	 * @param indto NC206DTO
	 * @return なし
	 * @customizable
	 */
	private void createCombo(NC206DTO indto){
		//1-2-1			所属役職
		//	コード情報から下記条件で値１：値１（漢字）を値１順に取得しドロップダウンリストを作成する
		//			コード名＝POSITION_CODE（所属役職）
		//			削除フラグ=0
		//			初期値
		SelectComboListEntity inEntityCmb = new SelectComboListEntity();
		inEntityCmb.setInCodeName(jp.co.takeda.rdm.util.RdmConstantsData.CODE_NAME_POSITION_CODE);
		List<SelectComboListEntity> outMainList = dao.select(inEntityCmb);
		LinkedHashMap<String, String> mapPositionCode = new LinkedHashMap<String, String>();
		mapPositionCode.put("", "--なし--");
		for (SelectComboListEntity outEntity : outMainList) {
			mapPositionCode.put(outEntity.getValue(), outEntity.getValueKanji());
		}
		indto.setPositionCodeCombo(mapPositionCode);

		//1-2-2			所属学会指導医区分
		//	下記で作成する
		//				'0'		--なし--
		//				'1'		○
		//				初期値
		LinkedHashMap<String, String> mapKbn = new LinkedHashMap<String, String>();
		mapKbn.put("0", "--なし--");
		mapKbn.put("1", "○");
		indto.setAdvisingDoctorCdCombo(mapKbn);

		//1-2-3			所属学会認定医区分
		//	下記で作成する
		//				'0'		--なし--
		//				'1'		○
		//				初期値
		indto.setCertifyingPhysicianCdCombo(mapKbn);

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

		indto.setAdmissionYYYYCombo(mapYear); // 入会年月日(年)
		indto.setAdmissionMMCombo(mapMonth); // 入会年月日(月)
		indto.setAdmissionDDCombo(mapDay); // 入会年月日(日)
		indto.setQuitYYYYCombo(mapYear); // 脱会年月日(年)
		indto.setQuitMMCombo(mapMonth); // 脱会年月日(月)
		indto.setQuitDDCombo(mapDay); // 脱会年月日(日)
		indto.setSocietyPosiStYYYYCombo(mapYear); // 役職開始年月日(年)
		indto.setSocietyPosiStMMCombo(mapMonth); // 役職開始年月日(月)
		indto.setSocietyPosiStDDCombo(mapDay); // 役職開始年月日(日)
		indto.setSocietyPosiEdYYYYCombo(mapYear); // 役職終了年月日(年)
		indto.setSocietyPosiEdMMCombo(mapMonth); // 役職終了年月日(月)
		indto.setSocietyPosiEdDDCombo(mapDay); // 役職終了年月日(日)
		indto.setCoachingAcquisiYYYYCombo(mapYear); // 指導医取得年月日(年)
		indto.setCoachingAcquisiMMCombo(mapMonth); // 指導医取得年月日(月)
		indto.setCoachingAcquisiDDCombo(mapDay); // 指導医取得年月日(日)
		indto.setCoachingStYYYYCombo(mapYear); // 指導医開始年月日(年)
		indto.setCoachingStMMCombo(mapMonth); // 指導医開始年月日(月)
		indto.setCoachingStDDCombo(mapDay); // 指導医開始年月日(日)
		indto.setCoachingEdYYYYCombo(mapYear); // 指導医終了年月日(年)
		indto.setCoachingEdMMCombo(mapMonth); // 指導医終了年月日(月)
		indto.setCoachingEdDDCombo(mapDay); // 指導医終了年月日(日)
		indto.setCertifyStYYYYCombo(mapYear); // 認定医開始年月日(年)
		indto.setCertifyStMMCombo(mapMonth); // 認定医開始年月日(月)
		indto.setCertifyStDDCombo(mapDay); // 認定医開始年月日(日)
		indto.setCertifyEdYYYYCombo(mapYear); // 認定医終了年月日(年)
		indto.setCertifyEdMMCombo(mapMonth); // 認定医終了年月日(月)
		indto.setCertifyEdDDCombo(mapDay); // 認定医終了年月日(日)

	}
	/**
	 * イベント処理
	 * @param indto NC206DTO
	 * @return 遷移先DTO
	 * @customizable
	 */
	@Transactional
	public BaseDTO register(NC206DTO indto) {
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

		LinkedHashMap<String,String> positionCodeCombo = indto.getPositionCodeCombo();
		indto.setPositionNamePop(positionCodeCombo.get(indto.getPositionCodePop()));
		LinkedHashMap<String,String> advisingDoctorCdCombo = indto.getAdvisingDoctorCdCombo();
		String advisingDoctorNm = advisingDoctorCdCombo.get(indto.getAdvisingDoctorCdPop());
		if(advisingDoctorNm.equals("--なし--")) {
			indto.setAdvisingDoctorNmPop("×");
		}else {
			indto.setAdvisingDoctorNmPop(advisingDoctorNm);
		}
		LinkedHashMap<String,String> certifyingPhysicianCdCombo = indto.getCertifyingPhysicianCdCombo();
		String certifyingPhysicianNm = certifyingPhysicianCdCombo.get(indto.getCertifyingPhysicianCdPop());
		if(certifyingPhysicianNm.equals("--なし--")) {
			indto.setCertifyingPhysicianNmPop("×");
		}else {
			indto.setCertifyingPhysicianNmPop(certifyingPhysicianNm);
		}

		indto.setReturnFlg("1");
		// END UOC
		return outdto;
	}

	/*
	 * エラーありならtrueとし、エラーメッセージをmsgStrにセットする
	 */
	private boolean checkInput(LoginInfo loginInfo, NC206DTO indto) {
		boolean errChk = false;
		boolean dateErrChk = false;
		String msgStr = "";
		String tmpMsgStr = "";
		//	１：必須入力チェック
		//	項目
		//	所属学会名
		if(StringUtils.isEmpty(indto.getMedicalSocietyNmPop())) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W004);//必須項目にデータを入力してください。（項目名）
			tmpMsgStr.replace("項目名", "所属学会名");
			msgStr = msgStr + tmpMsgStr + "\n";
		}
		//      ２：レングスチェック
		//      項目                                チェック内容
		int len = 0;
		//      所属学会名                              50文字を超えている場合
		len = indto.getMedicalSocietyNmPop().length();
		if(len > 50) {
			errChk = true;
			tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W009);//最大文字数を超えています。（項目名）
			tmpMsgStr = tmpMsgStr.replace("項目名", "所属学会名");
			msgStr = msgStr + tmpMsgStr + "\n";
		}

		//		６：範囲チェック
		//		項目                                チェック内容
		//		各種年月日項目	各種年月日項目の「月」「日」の組み合わせが存在しない日付であった場合 例：２月３０日　など
		//W022	有効な年月日を入力してください。（項目名）
		//入会年月日
		if(!StringUtils.isEmpty(indto.getAdmissionYYYYPop()) || !StringUtils.isEmpty(indto.getAdmissionMMPop()) || !StringUtils.isEmpty(indto.getAdmissionDDPop())) {
			if(!DateUtils.isDate(indto.getAdmissionYYYYPop() + indto.getAdmissionMMPop() + indto.getAdmissionDDPop())) {
				errChk = true;
				dateErrChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W022);//有効な年月日を入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "入会年月日");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//脱会年月日
		if(!StringUtils.isEmpty(indto.getQuitYYYYPop()) || !StringUtils.isEmpty(indto.getQuitMMPop()) || !StringUtils.isEmpty(indto.getQuitDDPop())) {
			if(!DateUtils.isDate(indto.getQuitYYYYPop() + indto.getQuitMMPop() + indto.getQuitDDPop())) {
				errChk = true;
				dateErrChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W022);//有効な年月日を入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "脱会年月日");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//役職開始年月日
		if(!StringUtils.isEmpty(indto.getSocietyPosiStYYYYPop()) || !StringUtils.isEmpty(indto.getSocietyPosiStMMPop()) || !StringUtils.isEmpty(indto.getSocietyPosiStDDPop())) {
			if(!DateUtils.isDate(indto.getSocietyPosiStYYYYPop() + indto.getSocietyPosiStMMPop() + indto.getSocietyPosiStDDPop())) {
				errChk = true;
				dateErrChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W022);//有効な年月日を入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "役職開始年月日");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//役職終了年月日
		if(!StringUtils.isEmpty(indto.getSocietyPosiEdYYYYPop()) || !StringUtils.isEmpty(indto.getSocietyPosiEdMMPop()) || !StringUtils.isEmpty(indto.getSocietyPosiEdDDPop())) {
			if(!DateUtils.isDate(indto.getSocietyPosiEdYYYYPop() + indto.getSocietyPosiEdMMPop() + indto.getSocietyPosiEdDDPop())) {
				errChk = true;
				dateErrChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W022);//有効な年月日を入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "役職終了年月日");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//指導医取得年月日
		if(!StringUtils.isEmpty(indto.getCoachingAcquisiYYYYPop()) || !StringUtils.isEmpty(indto.getCoachingAcquisiMMPop()) || !StringUtils.isEmpty(indto.getCoachingAcquisiDDPop())) {
			if(!DateUtils.isDate(indto.getCoachingAcquisiYYYYPop() + indto.getCoachingAcquisiMMPop() + indto.getCoachingAcquisiDDPop())) {
				errChk = true;
				dateErrChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W022);//有効な年月日を入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "指導医取得年月日");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//指導医開始年月日
		if(!StringUtils.isEmpty(indto.getCoachingStYYYYPop()) || !StringUtils.isEmpty(indto.getCoachingStMMPop()) || !StringUtils.isEmpty(indto.getCoachingStDDPop())) {
			if(!DateUtils.isDate(indto.getCoachingStYYYYPop() + indto.getCoachingStMMPop() + indto.getCoachingStDDPop())) {
				errChk = true;
				dateErrChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W022);//有効な年月日を入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "指導医開始年月日");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//指導医終了年月日
		if(!StringUtils.isEmpty(indto.getCoachingEdYYYYPop()) || !StringUtils.isEmpty(indto.getCoachingEdMMPop()) || !StringUtils.isEmpty(indto.getCoachingEdDDPop())) {
			if(!DateUtils.isDate(indto.getCoachingEdYYYYPop() + indto.getCoachingEdMMPop() + indto.getCoachingEdDDPop())) {
				errChk = true;
				dateErrChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W022);//有効な年月日を入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "指導医終了年月日");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//認定医開始年月日
		if(!StringUtils.isEmpty(indto.getCertifyStYYYYPop()) || !StringUtils.isEmpty(indto.getCertifyStMMPop()) || !StringUtils.isEmpty(indto.getCertifyStDDPop())) {
			if(!DateUtils.isDate(indto.getCertifyStYYYYPop() + indto.getCertifyStMMPop() + indto.getCertifyStDDPop())) {
				errChk = true;
				dateErrChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W022);//有効な年月日を入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "認定医開始年月日");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}
		//認定医終了年月日
		if(!StringUtils.isEmpty(indto.getCertifyEdYYYYPop()) || !StringUtils.isEmpty(indto.getCertifyEdMMPop()) || !StringUtils.isEmpty(indto.getCertifyEdDDPop())) {
			if(!DateUtils.isDate(indto.getCertifyEdYYYYPop() + indto.getCertifyEdMMPop() + indto.getCertifyEdDDPop())) {
				errChk = true;
				dateErrChk = true;
				tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W022);//有効な年月日を入力してください。（項目名）
				tmpMsgStr = tmpMsgStr.replace("項目名", "認定医終了年月日");
				msgStr = msgStr + tmpMsgStr + "\n";
			}
		}

		if(!dateErrChk) {//日付は有効な値または未設定である
			//		７：整合性チェック
			//      各種年月日項目	各種年月日項の開始・終了のが不適切（開始日＞終了日）な場合
			//入会年月日<脱会年月日
			if((!StringUtils.isEmpty(indto.getAdmissionYYYYPop()) && !StringUtils.isEmpty(indto.getAdmissionMMPop()) && !StringUtils.isEmpty(indto.getAdmissionDDPop()))
					&& (!StringUtils.isEmpty(indto.getQuitYYYYPop()) && !StringUtils.isEmpty(indto.getQuitMMPop()) && !StringUtils.isEmpty(indto.getQuitDDPop()))) {
				if(!DateUtils.compareDate((indto.getAdmissionYYYYPop() + indto.getAdmissionMMPop() + indto.getAdmissionDDPop())
						,(indto.getQuitYYYYPop() + indto.getQuitMMPop() + indto.getQuitDDPop()))){
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W003);//W003	終了日は開始日以降を選択してください。
					msgStr = msgStr + tmpMsgStr +"(脱会年月日)"+ "\n";
				}
			}
			//役職開始年月日<役職終了年月日
			if((!StringUtils.isEmpty(indto.getSocietyPosiStYYYYPop()) && !StringUtils.isEmpty(indto.getSocietyPosiStMMPop()) && !StringUtils.isEmpty(indto.getSocietyPosiStDDPop()))
					&& (!StringUtils.isEmpty(indto.getSocietyPosiEdYYYYPop()) && !StringUtils.isEmpty(indto.getSocietyPosiEdMMPop()) && !StringUtils.isEmpty(indto.getSocietyPosiEdDDPop()))) {
				if(!DateUtils.compareDate((indto.getSocietyPosiStYYYYPop() + indto.getSocietyPosiStMMPop() + indto.getSocietyPosiStDDPop())
						,(indto.getSocietyPosiEdYYYYPop() + indto.getSocietyPosiEdMMPop() + indto.getSocietyPosiEdDDPop()))){
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W003);//W003	終了日は開始日以降を選択してください。
					msgStr = msgStr + tmpMsgStr +"(役職終了年月日)"+ "\n";
				}
			}
			//指導医開始年月日<指導医終了年月日
			if((!StringUtils.isEmpty(indto.getCoachingStYYYYPop()) && !StringUtils.isEmpty(indto.getCoachingStMMPop()) && !StringUtils.isEmpty(indto.getCoachingStDDPop()))
					&& (!StringUtils.isEmpty(indto.getCoachingEdYYYYPop()) && !StringUtils.isEmpty(indto.getCoachingEdMMPop()) && !StringUtils.isEmpty(indto.getCoachingEdDDPop()))) {
				if(!DateUtils.compareDate((indto.getCoachingStYYYYPop() + indto.getCoachingStMMPop() + indto.getCoachingStDDPop())
						,(indto.getCoachingEdYYYYPop() + indto.getCoachingEdMMPop() + indto.getCoachingEdDDPop()))){
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W003);//W003	終了日は開始日以降を選択してください。
					msgStr = msgStr + tmpMsgStr +"(指導医終了年月日)"+ "\n";
				}
			}
			//認定医開始年月日<認定医終了年月日
			if((!StringUtils.isEmpty(indto.getCertifyStYYYYPop()) && !StringUtils.isEmpty(indto.getCertifyStMMPop()) && !StringUtils.isEmpty(indto.getCertifyStDDPop()))
					&& (!StringUtils.isEmpty(indto.getCertifyEdYYYYPop()) && !StringUtils.isEmpty(indto.getCertifyEdMMPop()) && !StringUtils.isEmpty(indto.getCertifyEdDDPop()))) {
				if(!DateUtils.compareDate((indto.getCertifyStYYYYPop() + indto.getCertifyStMMPop() + indto.getCertifyStDDPop())
						,(indto.getCertifyEdYYYYPop() + indto.getCertifyEdMMPop() + indto.getCertifyEdDDPop()))){
					errChk = true;
					tmpMsgStr = loginInfo.getMsgData(RdmConstantsData.W003);//W003	終了日は開始日以降を選択してください。
					msgStr = msgStr + tmpMsgStr +"(認定医終了年月日)"+ "\n";
				}
			}
		}
		if(errChk) {//エラーありなのでメッセージをセットする
			indto.setMsgStr(msgStr);
		}
		return errChk;
	}

}

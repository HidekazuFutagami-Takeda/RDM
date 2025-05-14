/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Named;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseInfoHolder;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.BeanUtil;
import jp.co.takeda.rdm.common.LoginInfo;
import jp.co.takeda.rdm.entity.join.SelectInitJgiEntity;
import jp.co.takeda.rdm.entity.join.SelectCntUnderSosEntity;
import jp.co.takeda.rdm.entity.join.SelectJgiEntity;
import jp.co.takeda.rdm.entity.join.SelectJgiJgiEntity;
import jp.co.takeda.rdm.entity.join.SelectRyakuNameEntity;
import jp.co.takeda.rdm.entity.join.SelectInitSosAutoEntity;
import jp.co.takeda.rdm.dto.NC202DTO;
import jp.co.takeda.rdm.dto.JgiData;
import jp.co.takeda.rdm.dto.SosJgiInitData;
import jp.co.takeda.rdm.dto.JgiJgiData;
import jp.co.takeda.rdm.dto.JgiInitData;
import jp.co.takeda.rdm.util.StringUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviceクラス（NC202)
 * @generated
 */
@Named
public class NC202Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NC202Service.class);

    /**
     * イベント処理
     * @param indto RDMNC202DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NC202DTO indto) {
        BaseDTO outdto = indto;

        //自動展開用の組織コード(sos_cd)をセット
        //sos_cd == nullの場合はwhileをスキップ、自動展開しない
        String sosCdFlg = indto.getSosCd();

        List<JgiInitData> jgiInitDataList = new ArrayList<JgiInitData>();
        SelectInitJgiEntity selectInitJgiEntity = new SelectInitJgiEntity();

        List<SelectInitJgiEntity> selectInitJgiList = dao.select(selectInitJgiEntity);
        if (selectInitJgiList.size() > 0) {
        	SelectInitJgiEntity entity = selectInitJgiList.get(0);
        	JgiInitData data = new JgiInitData();
        	BeanUtil.copyProperties(data, entity);
        	jgiInitDataList.add(data);
        	if("01050".equals(entity.getSosCd())){
        		jgiInitDataList.clear();
                SelectInitJgiEntity selectInitJgiEntityTop = new SelectInitJgiEntity();
                selectInitJgiEntityTop.setInBumonRank(1);
                List<SelectInitJgiEntity> selectInitJgiListTop = dao.select(selectInitJgiEntityTop);

                SelectInitJgiEntity entityTop = (SelectInitJgiEntity)selectInitJgiListTop.get(0);
                JgiInitData dataTop = new JgiInitData();
                BeanUtil.copyProperties(dataTop, entityTop);
                jgiInitDataList.add(dataTop);
        	}

        }
        //SosCdPopにデータコピー　initでDTOに値をセットしないと以降セットできなくなるため。
        indto.setSosCdSearch(indto.getSosCdPop());
        indto.setBumonRankSearch(indto.getBumonRankPop());
        indto.setJgiInitData(jgiInitDataList);

        indto.setAjaxSwitchFlg("1");

    	//自動展開用のリスト取得
    	//親画面から組織コードを受け取っている場合に実行
        if(!(sosCdFlg == null || sosCdFlg.isEmpty())) {

        	List<SosJgiInitData> sosJgiInitDataList = new ArrayList<SosJgiInitData>();

        	boolean loopFlg = true;
        	String searchSosCd = indto.getSosCd();

        	while(loopFlg) {
        		SelectInitSosAutoEntity selectInitSosAutoEntity = new SelectInitSosAutoEntity();
        		selectInitSosAutoEntity.setInSosCd(Integer.parseInt(searchSosCd));
        		List<SelectInitSosAutoEntity> entity = dao.select(selectInitSosAutoEntity);
    			SosJgiInitData data = new SosJgiInitData();
    			SelectInitSosAutoEntity entityTop = (SelectInitSosAutoEntity)entity.get(0);
    			BeanUtil.copyProperties(data, entityTop);
    			sosJgiInitDataList.add(data);
    			searchSosCd = entity.get(0).getUpSosCode();
        		if(data.getSosCd().equals("01050")) {
        			loopFlg = false;
        		}
        	}

            //下位組織から上位組織探すため、上位組織から下位組織の順序にしておく必要
            Comparator<SosJgiInitData> listOrder =
                new Comparator<SosJgiInitData>() {
                public int compare(SosJgiInitData e1,
                		SosJgiInitData e2) {
                    return e1.getBumonRank() - e2.getBumonRank();
                }
            };
            Collections.sort(sosJgiInitDataList, listOrder);

            indto.setSosJgiInitData(sosJgiInitDataList);

        	indto.setAjaxSwitchFlg("2");
        }

        // END UOC
        return outdto;
    }


    /**
     * イベント処理
     * @param indto RDMNC201DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO ajaxJgi(NC202DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        getJgiList(0, indto);
        // END UOC
        return outdto;
    }

    /** 表示組織リスト取得。
    *
    * @param initFlg 0：初期以外、1：初期
    * @param indto RDMNC202DTO
    * @param searchUpSosCd 初期：最上位組織コード、それ以外：展開組織コード
    */
   @Transactional
   private void getJgiList(int initFlg, NC202DTO indto) {
	   LoginInfo loginInfo = (LoginInfo)BaseInfoHolder.getUserInfo();
       SelectJgiEntity selectJgiEntity = new SelectJgiEntity();
       selectJgiEntity.setInBumonRank(initFlg);
       selectJgiEntity.setInUpSosCd(null);
       selectJgiEntity.setInJokenSetCd(loginInfo.getJokenSetCd());
       if (initFlg == 0) {
    	   selectJgiEntity.setInBumonRank(indto.getBumonRankPop()+ 1);
    	   selectJgiEntity.setInUpSosCd(indto.getSosCdPop());
       }

       SelectCntUnderSosEntity selectCntUnderSosEntity = new SelectCntUnderSosEntity();
       selectCntUnderSosEntity.setInSosCd(selectJgiEntity.getInUpSosCd());
       List<SelectCntUnderSosEntity> selectCntUnderSosList = dao.select(selectCntUnderSosEntity);
       if (selectCntUnderSosList.size() > 0) {

			if (indto.getBackScreenId().equals("NF011")) {
				selectJgiEntity.setInGmnFlg(0);
				selectJgiEntity.setInTrtCd(StringUtils.setEmptyToNull(indto.getTrtCdPop()));
				selectJgiEntity.setInAddrCodePref(StringUtils.setEmptyToNull(indto.getAddrCodePrefPop()));
				selectJgiEntity.setInTkCityCd(StringUtils.setEmptyToNull(indto.getTkCityCdPop()));
				selectJgiEntity.setInSosCdPop(loginInfo.getSosCd());
				selectJgiEntity.setInUpSosCdPop(loginInfo.getUpSosCd());
				Integer tempBumonRank = Integer.parseInt(loginInfo.getBumonRank());
				selectJgiEntity.setInBumonRankPop(tempBumonRank);

			} else {
				selectJgiEntity.setInGmnFlg(1);
				selectJgiEntity.setInSosCdPop(indto.getSosCdPop());
				selectJgiEntity.setInUpSosCdPop(StringUtils.setEmptyToNull(indto.getUpSosCdPop()));
				selectJgiEntity.setInBumonRankPop(indto.getBumonRankSearch());
				selectJgiEntity.setInSosCdSearch(indto.getSosCdSearch());
			}

			List<SelectJgiEntity> selectJgiList = dao.select(selectJgiEntity);

			List<JgiData> jgiDataList = new ArrayList<JgiData>(selectJgiList.size());

			for (SelectJgiEntity entity : selectJgiList) {
				JgiData data = new JgiData();
				BeanUtil.copyProperties(data, entity);
				jgiDataList.add(data);
			}
			indto.setJgiData(jgiDataList);

		}

       SelectJgiJgiEntity selectJgiJgiEntity = new SelectJgiJgiEntity();
       selectJgiJgiEntity.setInBumonRank(initFlg);
       selectJgiJgiEntity.setInUpSosCd(null);
       selectJgiJgiEntity.setInJokenSetCd(loginInfo.getJokenSetCd());
       if (initFlg == 0) {
    	   selectJgiJgiEntity.setInBumonRank(indto.getBumonRankPop()+ 1);
    	   selectJgiJgiEntity.setInUpSosCd(indto.getSosCdPop());
       }

       if (indto.getBackScreenId().equals("NF011")) {
    	   selectJgiJgiEntity.setInGmnFlg(0);
    	   selectJgiJgiEntity.setInTrtCd(StringUtils.setEmptyToNull(indto.getTrtCdPop()));
    	   selectJgiJgiEntity.setInAddrCodePref(StringUtils.setEmptyToNull(indto.getAddrCodePrefPop()));
    	   selectJgiJgiEntity.setInTkCityCd(StringUtils.setEmptyToNull(indto.getTkCityCdPop()));
    	   selectJgiJgiEntity.setInSosCdPop(loginInfo.getSosCd());
    	   selectJgiJgiEntity.setInUpSosCdPop(loginInfo.getUpSosCd());
    	   Integer tempBumonRank = Integer.parseInt(loginInfo.getBumonRank());
    	   selectJgiJgiEntity.setInBumonRankPop(tempBumonRank);

       }else {
    	   selectJgiJgiEntity.setInGmnFlg(1);
    	   selectJgiJgiEntity.setInSosCdPop(indto.getSosCdPop());
    	   selectJgiJgiEntity.setInUpSosCdPop(indto.getUpSosCdPop());
    	   selectJgiJgiEntity.setInBumonRankPop(indto.getBumonRankPop());
       }

       List<SelectJgiJgiEntity> selectJgiJgiList = dao.select(selectJgiJgiEntity);


		if (!(selectJgiJgiList == null || selectJgiJgiList.isEmpty())) {
			String sosCd = selectJgiJgiList.get(0).getSosCd();

			SelectRyakuNameEntity selectRyakuNameEntity = new SelectRyakuNameEntity();
			selectRyakuNameEntity.setInSosCd(sosCd);
			List<SelectRyakuNameEntity> selectRyakuNameList = dao.select(selectRyakuNameEntity);
			String sosName = selectRyakuNameList.get(0).getBumonRyakuName();

			for (SelectJgiJgiEntity entity : selectJgiJgiList) {
				String nameJoin;
				nameJoin = sosName + "　"+ entity.getBumonRyakuName();
				entity.setBumonRyakuName(nameJoin);
			}
		}


       List<JgiJgiData> jgiJgiDataList = new ArrayList<JgiJgiData>(selectJgiJgiList.size());

       for (SelectJgiJgiEntity entity : selectJgiJgiList) {
           JgiJgiData data = new JgiJgiData();
           BeanUtil.copyProperties(data, entity);
           jgiJgiDataList.add(data);
       }

       indto.setJgiJgiData(jgiJgiDataList);
   }
}
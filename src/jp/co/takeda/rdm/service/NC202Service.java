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
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.BeanUtil;
import jp.co.takeda.rdm.entity.join.SelectInitJgiEntity;
//import jp.co.takeda.rdm.entity.join.SelectInitSosEntity;
import jp.co.takeda.rdm.entity.join.SelectJgiEntity;
//import jp.co.takeda.rdm.entity.join.SelectSosEntity;
import jp.co.takeda.rdm.dto.NC202DTO;
//import jp.co.takeda.rdm.dto.SosInitData;
import jp.co.takeda.rdm.dto.JgiData;
import jp.co.takeda.rdm.dto.JgiInitData;
import jp.co.takeda.rdm.dto.NC201DTO;
import jp.co.takeda.rdm.util.RdmConstantsData;
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
//                selectInitJgiEntityTop.setInTrtCd(null);
                List<SelectInitJgiEntity> selectInitJgiListTop = dao.select(selectInitJgiEntityTop);

                SelectInitJgiEntity entityTop = (SelectInitJgiEntity)selectInitJgiListTop.get(0);
                JgiInitData dataTop = new JgiInitData();
                BeanUtil.copyProperties(dataTop, entityTop);
                jgiInitDataList.add(dataTop);
        	}

        }

        indto.setJgiInitData(jgiInitDataList);
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

        indto.setJgiFlg(0);
        String jgiFlg = indto.getJgiData().get(0).getJgiNo();
        if(!StringUtils.isEmpty(jgiFlg)) {
        	indto.setJgiFlg(1);
        }
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
   	//消すこと　表示領域を制限するために使用
//   	indto.setTrtCdPop("06");

       SelectJgiEntity selectJgiEntity = new SelectJgiEntity();
       selectJgiEntity.setInBumonRank(initFlg);
//       selectJgiEntity.setInTrtCd(StringUtils.setEmptyToNull(null));
       selectJgiEntity.setInUpSosCd(null);
       if (initFlg == 0) {
    	   selectJgiEntity.setInBumonRank(indto.getBumonRankPop()+ 1);
//    	   selectJgiEntity.setInTrtCd(StringUtils.setEmptyToNull(indto.getTrtCdPop()));
    	   selectJgiEntity.setInUpSosCd(indto.getSosCdPop());
       }
       //注意_以下の値は親画面が完成次第、比較対象の値を変更すること
       if (indto.getWinVarName().equals("gCseViewWi")) {
    	   selectJgiEntity.setInGmnFlg(0);
    	   selectJgiEntity.setInTrtCd("02");
    	   selectJgiEntity.setInAddrCodePref("01");
    	   selectJgiEntity.setInTkCityCd("018");
    	   //selectJgiEntity.setInTrtCd(indto.getTrtCdPop());
    	   //selectJgiEntity.setInAddrCodePref(indto.getAddrCodePrefPop());
    	   //selectJgiEntity.setInTkCityCd(indto.getTkCityCdPop());

       }else {
    	   selectJgiEntity.setInGmnFlg(1);
    	   selectJgiEntity.setInTrtCd("02");
    	   selectJgiEntity.setInSosCd("04199");
    	   //selectJgiEntity.setInTrtCd(indto.getTrtCdPop());
    	   //selectJgiEntity.setInSosCd(indto.getSosCdPop());
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
}

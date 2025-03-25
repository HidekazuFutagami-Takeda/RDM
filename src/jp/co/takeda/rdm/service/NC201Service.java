/*
 * ALL RIGHTS RESERVED,
 * COPYRIGHT (C) 2013, HITACHI SOLUTIONS, Ltd.
 */
//## AutomaticGeneration
package jp.co.takeda.rdm.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import jp.co.takeda.rdm.common.BaseDTO;
import jp.co.takeda.rdm.common.BaseService;
import jp.co.takeda.rdm.common.BeanUtil;
import jp.co.takeda.rdm.dto.NC201DTO;
import jp.co.takeda.rdm.dto.SosInitData;
import jp.co.takeda.rdm.dto.SosData;
import jp.co.takeda.rdm.entity.join.SelectInitSosEntity;
import jp.co.takeda.rdm.entity.join.SelectSosEntity;
import jp.co.takeda.rdm.util.StringUtils;
import jp.co.takeda.rdm.entity.join.SelectRyakuNameEntity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Serviceクラス（NC201)
 * @generated
 */
@Named
public class NC201Service extends BaseService {

    /**
     * ログインスタンス
     * @generated
     */
    private static Log log = LogFactory.getLog(NC201Service.class);

    /**
     * イベント処理
     * @param indto RDMNC201DTO
     * @return 遷移先DTO
     * @customizable
     */
    @Transactional
    public BaseDTO init(NC201DTO indto) {
        BaseDTO outdto = indto;

        List<SosInitData> sosInitDataList = new ArrayList<SosInitData>();
        // １－４－１．以下のSQLを実行し、初期表示組織の情報を取得する。
        //    ※初期表示組織の設定がない場合は、表示対象の最上位階層の組織とする。

        SelectInitSosEntity selectInitSosEntity = new SelectInitSosEntity();
        selectInitSosEntity.setInBumonRank(1);
        selectInitSosEntity.setInTrtCd(null);
        List<SelectInitSosEntity> selectInitSosList = dao.select(selectInitSosEntity);
        if (selectInitSosList.size() > 0) {
            // 論理的に1件検索であるため、1件目を使用する。
        	SelectInitSosEntity entity = selectInitSosList.get(0);
            SosInitData data = new SosInitData();
            BeanUtil.copyProperties(data, entity);
            sosInitDataList.add(data);
            if("01050".equals(entity.getSosCd())){	// 最上位組織が初期組織リストに含まれない場合
                // 【初期組織リスト】を初期化し、最上位組織の情報を取得して格納する。
            	sosInitDataList.clear();
                SelectInitSosEntity selectInitSosEntityTop = new SelectInitSosEntity();
                selectInitSosEntityTop.setInBumonRank(1);
                selectInitSosEntityTop.setInTrtCd(null);
                List<SelectInitSosEntity> selectInitSosListTop = dao.select(selectInitSosEntityTop);

                SelectInitSosEntity entityTop = (SelectInitSosEntity)selectInitSosListTop.get(0);
                SosInitData dataTop = new SosInitData();
                BeanUtil.copyProperties(dataTop, entityTop);
                dataTop.setBumonRankPop(1);
                sosInitDataList.add(dataTop);

            }
        }

        indto.setSosInitData(sosInitDataList);

        // １－５．画面に表示する組織情報を取得する。
        // ※ArrayList型の変数【表示組織リスト】にデータを格納していく。
        // ※初期表示時は最上位組織の情報のみ取得
        getSosList(1, indto);
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
    public BaseDTO ajaxSos(NC201DTO indto) {
        BaseDTO outdto = indto;
        // START UOC
        // 組織選択の場合
        getSosList(0, indto);

        // END UOC
        return outdto;
    }

    /** 表示組織リスト取得。
     *
     * @param initFlg 0：初期以外、1：初期
     * @param indto RDMNC201DTO
     * @param searchUpSosCd 初期：最上位組織コード、それ以外：展開組織コード
     */
    @Transactional
    private void getSosList(int initFlg, NC201DTO indto) {
    	//消すこと　表示領域を制限するために使用
//    	indto.setTrtCdPop("06");

        SelectSosEntity selectSosEntity = new SelectSosEntity();
        selectSosEntity.setInBumonRank(initFlg);
        selectSosEntity.setInTrtCd(StringUtils.setEmptyToNull(null));
        selectSosEntity.setInUpSosCd(null);
        if (initFlg == 0) {
            selectSosEntity.setInBumonRank(indto.getBumonRankPop()+ 1);
            selectSosEntity.setInTrtCd(StringUtils.setEmptyToNull(indto.getTrtCdPop()));
            selectSosEntity.setInUpSosCd(indto.getSosCdPop());
        }
        List<SelectSosEntity> selectSosList = dao.select(selectSosEntity);
        List<SosData> sosDataList = new ArrayList<SosData>(selectSosList.size());

        for (SelectSosEntity entity : selectSosList) {
            SosData data = new SosData();
            BeanUtil.copyProperties(data, entity);
            sosDataList.add(data);
        }
        indto.setSosData(sosDataList);
    }
}

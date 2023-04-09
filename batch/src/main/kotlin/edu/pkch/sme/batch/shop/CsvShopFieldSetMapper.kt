package edu.pkch.sme.batch.shop

import org.springframework.batch.item.file.mapping.FieldSetMapper
import org.springframework.batch.item.file.transform.FieldSet

class CsvShopFieldSetMapper: FieldSetMapper<CsvShop> {

    override fun mapFieldSet(fieldSet: FieldSet): CsvShop {
        return CsvShop(
            fieldSet.readLong("상가업소번호"),
            fieldSet.readString("상호명"),
            fieldSet.readString("지점명"),
            fieldSet.readString("상권업종대분류명"),
            fieldSet.readString("상권업종중분류명"),
            fieldSet.readString("표준산업분류명"),
            fieldSet.readString("시도명"),
            fieldSet.readString("시군구명"),
            fieldSet.readString("행정동명"),
            fieldSet.readString("법정동명"),
            fieldSet.readString("지번본번지"),
            fieldSet.readString("지번부번지"),
            fieldSet.readString("도로명"),
            fieldSet.readString("건물본번지"),
            fieldSet.readString("건물부번지"),
            fieldSet.readString("건물명"),
            fieldSet.readDouble("경도"),
            fieldSet.readDouble("위도"),
        )
    }
}
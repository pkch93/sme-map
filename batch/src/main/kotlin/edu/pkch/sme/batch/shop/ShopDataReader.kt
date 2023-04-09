package edu.pkch.sme.batch.shop

import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.mapping.DefaultLineMapper
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer
import org.springframework.core.io.ClassPathResource

class ShopDataReader(
    resourcePath: String,
    offset: Int
): FlatFileItemReader<CsvShop>() {

    init {
        val lineMapper: DefaultLineMapper<CsvShop> = DefaultLineMapper()
        val tokenizer = DelimitedLineTokenizer()
        tokenizer.setNames(
            "상가업소번호",
            "상호명",
            "지점명",
            "상권업종대분류코드",
            "상권업종대분류명",
            "상권업종중분류코드",
            "상권업종중분류명",
            "상권업종소분류코드",
            "상권업종소분류명",
            "표준산업분류코드",
            "표준산업분류명",
            "시도코드",
            "시도명",
            "시군구코드",
            "시군구명",
            "행정동코드",
            "행정동명",
            "법정동코드",
            "법정동명",
            "지번코드",
            "대지구분코드",
            "대지구분명",
            "지번본번지",
            "지번부번지",
            "지번주소",
            "도로명코드",
            "도로명",
            "건물본번지",
            "건물부번지",
            "건물관리번호",
            "건물명",
            "도로명주소",
            "구우편번호",
            "신우편번호",
            "동정보",
            "층정보",
            "호정보",
            "경도",
            "위도")
        lineMapper.setLineTokenizer(tokenizer)
        lineMapper.setFieldSetMapper(CsvShopFieldSetMapper())

        this.setResource(ClassPathResource(resourcePath))
        this.setLineMapper(lineMapper)
        this.setLinesToSkip(offset)
    }
}
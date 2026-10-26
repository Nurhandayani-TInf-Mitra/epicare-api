package epicare_api.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class SatuanFrekuensiConverter
        implements AttributeConverter<ResepDetail.SatuanFrekuensi, String> {

    @Override
    public String convertToDatabaseColumn(
            ResepDetail.SatuanFrekuensi satuan) {
        return satuan == null ? null : satuan.getNilaiDatabase();
    }

    @Override
    public ResepDetail.SatuanFrekuensi convertToEntityAttribute(
            String nilai) {
        return nilai == null ? null
                : ResepDetail.SatuanFrekuensi.dariNilaiDatabase(nilai);
    }
}
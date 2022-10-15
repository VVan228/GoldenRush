package hack.polyus.goldenrush.services;

import hack.polyus.goldenrush.models.transport.TransportParam;
import hack.polyus.goldenrush.models.transport.TransportParamValueEnum;
import hack.polyus.goldenrush.models.transport.TransportType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TransportDataServiceImpl implements TransportDataService{

    List<TransportParam> params = new ArrayList<>();
    List<TransportType> types = new ArrayList<>();
    List<TransportParamValueEnum> paramValuesEnums = new ArrayList<>();

    TransportType transportType = new TransportType();
    TransportType transportType1 = new TransportType();
    TransportType transportType2 = new TransportType();

    TransportParam transportParam0 = new TransportParam();
    TransportParam transportParam1 = new TransportParam();
    TransportParam transportParam20 = new TransportParam();
    TransportParam transportParam21 = new TransportParam();
    TransportParam transportParam22 = new TransportParam();
    TransportParam transportParam23 = new TransportParam();
    TransportParamValueEnum val22   = new TransportParamValueEnum();
    TransportParamValueEnum val221  = new TransportParamValueEnum();
    TransportParamValueEnum val222   = new TransportParamValueEnum();
    TransportParamValueEnum val21   = new TransportParamValueEnum();
    TransportParamValueEnum val223   = new TransportParamValueEnum();
    TransportParamValueEnum val224   = new TransportParamValueEnum();
    TransportParamValueEnum val01    = new TransportParamValueEnum();
    TransportParamValueEnum val02    = new TransportParamValueEnum();
    TransportParamValueEnum val03    = new TransportParamValueEnum();
    TransportParamValueEnum val04   = new TransportParamValueEnum();
    TransportParamValueEnum val05    = new TransportParamValueEnum();
    TransportParamValueEnum val1     = new TransportParamValueEnum();
    TransportParamValueEnum val11   = new TransportParamValueEnum();
    TransportParamValueEnum val12   = new TransportParamValueEnum();
    TransportParamValueEnum val13   = new TransportParamValueEnum();
    TransportParamValueEnum val14    = new TransportParamValueEnum();
    TransportParamValueEnum val15   = new TransportParamValueEnum();
    TransportParamValueEnum val16    = new TransportParamValueEnum();
    TransportParamValueEnum val17   = new TransportParamValueEnum();
    TransportParamValueEnum val201  = new TransportParamValueEnum();
    TransportParamValueEnum val203  = new TransportParamValueEnum();
    TransportParamValueEnum val204  = new TransportParamValueEnum();
    TransportParamValueEnum val202  = new TransportParamValueEnum();
    TransportParamValueEnum val205  = new TransportParamValueEnum();

    TransportType transportType00 = new TransportType();
    TransportType transportType10 = new TransportType();
    TransportType transportType20 = new TransportType();

    public TransportDataServiceImpl() {
        transportType00.setName("Парк Автовышек");
        transportType00.setId(0L);

        transportType10.setName("Парк Автокранов");
        transportType10.setId(1L);

        transportType20.setName("Парк Погрузчиков");
        transportType20.setId(2L);


        transportParam0.setId(0L);
        transportParam0.setTypeId(transportType00.getId());
        transportParam0.setName("Высота");
        transportParam0.setEnum(true);

        transportParam1.setId(1L);
        transportParam1.setTypeId(transportType10.getId());
        transportParam1.setName("Грузоподъёмность");
        transportParam1.setEnum(true);

        transportParam20.setId(20L);
        transportParam20.setTypeId(transportType20.getId());
        transportParam20.setName("Тип Погрузчика");
        transportParam20.setEnum(true);

        transportParam21.setId(21L);
        transportParam21.setTypeId(transportType20.getId());
        transportParam21.setName("Тип Топлива");
        transportParam21.setEnum(true);

        transportParam22.setId(22L);
        transportParam22.setTypeId(transportType20.getId());
        transportParam22.setName("Ёмкость Ковша");
        transportParam22.setEnum(true);

        transportParam23.setId(23L);
        transportParam23.setTypeId(transportType20.getId());
        transportParam23.setName("Грузоподъёмность");
        transportParam23.setEnum(true);



        val21.setId(21L);
        val21.setName("Дизель");
        val21.setParamId(transportParam21.getId());


        val22.setId(22L);
        val22.setName("Бензин");
        val22.setParamId(transportParam21.getId());


        val221.setId(221L);
        val221.setName("5,4");
        val221.setParamId(transportParam22.getId());


        val222.setId(222L);
        val222.setName("6");
        val222.setParamId(transportParam22.getId());


        val223.setId(223L);
        val223.setName("3");
        val223.setParamId(transportParam22.getId());


        val224.setId(224L);
        val224.setName("8");
        val224.setParamId(transportParam22.getId());


        val01.setId(01L);
        val01.setName("28");
        val01.setParamId(transportParam0.getId());


        val02.setId(02L);
        val02.setName("32");
        val02.setParamId(transportParam0.getId());


        val03.setId(03L);
        val03.setName("35");
        val03.setParamId(transportParam0.getId());


        val04.setId(04L);
        val04.setName("45");
        val04.setParamId(transportParam0.getId());


        val05.setId(05L);
        val05.setName("70");
        val05.setParamId(transportParam0.getId());


        val1.setId(1L);
        val1.setName("100");
        val1.setParamId(transportParam1.getId());

        val11.setId(11L);
        val11.setName("16");
        val11.setParamId(transportParam1.getId());


        val12.setId(12L);
        val12.setName("160");
        val12.setParamId(transportParam1.getId());

        val13.setId(13L);
        val13.setName("25");
        val13.setParamId(transportParam1.getId());

        val14.setId(14L);
        val14.setName("35");
        val14.setParamId(transportParam1.getId());

        val15.setId(15L);
        val15.setName("50");
        val15.setParamId(transportParam1.getId());

        val16.setId(16L);
        val16.setName("60");
        val16.setParamId(transportParam1.getId());

        val17.setId(17L);
        val17.setName("70");
        val17.setParamId(transportParam1.getId());

        val201.setId(201L);
        val201.setName("Погрузчик_Телескопический");
        val201.setParamId(transportParam20.getId());


        val202.setId(202L);
        val202.setName("Погрузчик_Вилочный");
        val202.setParamId(transportParam20.getId());

        val203.setId(203L);
        val203.setName("Погрузчик_Ричтрак_контейнерный");
        val203.setParamId(transportParam20.getId());

        val204.setId(204L);
        val204.setName("Погрузчик_с_боковым_поворотом");
        val204.setParamId(transportParam20.getId());

        val205.setId(205L);
        val205.setName("Погрузчик_Фронтальный");
        val205.setParamId(transportParam20.getId());




        params.add(transportParam0);
        params.add(transportParam1);
        params.add(transportParam20);
        params.add(transportParam21);
        params.add(transportParam23);


        types.add(transportType00);
        types.add(transportType10);
        types.add(transportType20);

        paramValuesEnums.add(val22 );
        paramValuesEnums.add(val221);
        paramValuesEnums.add(val222);
        paramValuesEnums.add(val21 );
        paramValuesEnums.add(val223);
        paramValuesEnums.add(val224);
        paramValuesEnums.add(val01 );
        paramValuesEnums.add(val02 );
        paramValuesEnums.add(val03 );
        paramValuesEnums.add(val04 );
        paramValuesEnums.add(val05 );
        paramValuesEnums.add(val1  );
        paramValuesEnums.add(val11 );
        paramValuesEnums.add(val12 );
        paramValuesEnums.add(val13 );
        paramValuesEnums.add(val14 );
        paramValuesEnums.add(val15 );
        paramValuesEnums.add(val16 );
        paramValuesEnums.add(val17 );
        paramValuesEnums.add(val201);
        paramValuesEnums.add(val203);
        paramValuesEnums.add(val204);
        paramValuesEnums.add(val202);
        paramValuesEnums.add(val205);

    }




    @Override
    public List<TransportParam> getParams(TransportType type) {
        List<TransportParam> res = new ArrayList<>();
        for(TransportParam t: params){
            if(Objects.equals(t.getTypeId(), type.getId())){
                res.add(t);
            }
        }
        return res;
    }

    @Override
    public List<TransportType> getTypes() {
        return types;
    }

    @Override
    public List<TransportParamValueEnum> getParamValueEnums(TransportParam param) {
        List<TransportParamValueEnum> res = new ArrayList<>();
        for(TransportParamValueEnum t: paramValuesEnums){
            if(Objects.equals(t.getParamId(), param.getId())){
                res.add(t);
            }
        }
        return res;
    }

    @Override
    public TransportType getType(Long typeId) {
        TransportType res = null;
        for(TransportType t: types){
            if(Objects.equals(t.getId(), typeId)){
                res = t;
            }
        }
        return res;
    }

    @Override
    public TransportParam getParam(Long paramId) {
        TransportParam res = null;
        for(TransportParam t: params){
            if(Objects.equals(t.getId(), paramId)){
                res = t;
            }
        }
        return res;
    }
}

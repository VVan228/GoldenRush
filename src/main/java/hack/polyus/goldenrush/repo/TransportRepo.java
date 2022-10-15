package hack.polyus.goldenrush.repo;

import hack.polyus.goldenrush.models.transport.Transport;
import hack.polyus.goldenrush.models.transport.TransportParam;
import hack.polyus.goldenrush.models.transport.TransportParamValueEnum;
import hack.polyus.goldenrush.models.transport.TransportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransportRepo extends JpaRepository<Transport, Long> {
    @Query("select t from TransportType t")
    List<TransportType> getAllTransportTypes();

    @Query("select params from TransportParam params where params.typeId=:checkedTypeId")
    List<TransportParam> getParams(@Param("checkedTypeId") Long checkedTypeId);

    @Query ("select values from TransportParamValueEnum  values where values.paramId=:paramId")
    List<TransportParamValueEnum> getParamValues(@Param("paramId") Long paramId);


}

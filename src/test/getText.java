import org.junit.Test;
import service.DXF_Extract;

/**
 * Created by Administrator on 2017/4/13.
 */
public class getText {

    DXF_Extract extract = new DXF_Extract();

    @Test
    public void getText(){
        extract.parseFile("F:\\DXF_Files\\cjyb.dxf");
    }
}

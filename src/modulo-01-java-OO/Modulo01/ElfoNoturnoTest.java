

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test
    public void elfonOTURNOMorre(){
        ElfoNoturno night = new ElfoNoturno("Night");
        for(int i=0; i<1000; i++){
            night.atirarFlecha();
        }
        assertEquals(Status.MORTO, night.getStatus());
    }
}

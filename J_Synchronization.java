package Package01;

/**
 * @author WangChen
 * @create 2020-05-05 7:34
 */
class J_Experiment
{
    private int m_temperature,m_pressure;
    public void mb_update(int t,int p)
    {
        m_temperature=t;
        m_pressure=p;
    }
    public void mb_analyze()
    {
        int t=m_temperature;
        int p=m_pressure;
        for(int i=0;i<1000;i++)
            ;
        if(t!=m_temperature)
        {
            System.out.print("实验数据出现情况：");
            System.out.println("t("+t+")!=("+m_temperature+")");
            System.exit(0);
        }
        if(p!=m_pressure)
        {
            System.out.print("实验数据出现情况：");
            System.out.println("p("+p+")!=("+m_pressure+")");
            System.exit(0);
        }
    }

}
class J_Assistant extends Thread
{
    J_Experiment m_data;

    public J_Assistant(J_Experiment m_data) {
        this.m_data = m_data;
    }

    @Override
    public void run() {
        int i,j;
        while(true)
        {
            i=(int)(Math.random()*1000);
            j=(int)(Math.random()*1000);
        }
    }
}

class J_Analyst extends Thread
{
    J_Experiment m_data;
    public  J_Analyst(J_Experiment d)
    {
        m_data=d;
    }
    public void run()
    {
        for(;true;)
        {
            m_data.mb_analyze();
        }
    }

}

public class J_Synchronization {
    public static void main(String[] args) {
        J_Experiment data=new J_Experiment();
        J_Assistant threadA=new J_Assistant(data);
        J_Analyst threadB=new J_Analyst(data);
        threadA.start();
        threadB.start();
    }
}

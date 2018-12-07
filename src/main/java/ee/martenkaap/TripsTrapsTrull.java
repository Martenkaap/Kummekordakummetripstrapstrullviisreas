package ee.martenkaap;

public class TripsTrapsTrull
{
    private int[] manguVali=new int[101];
    private int aktiivneMangija = 1;
    private int kasmangkaibveel = 1;
    private int voitja = 0;

    public void manguvalitaiestialgus()
    {
        for(int s=0; s<101; s=s+1){
            int k = 0;
            manguVali[s]=k;
        }
    }


    private void vahetaMangija()
    {
        if(aktiivneMangija == 1)
            aktiivneMangija=2;
        else
            aktiivneMangija = 1;
    }

    public void restart()
    {
        manguvalitaiestialgus();
        aktiivneMangija = 1;
    }

    public boolean teeKaik(int asukoht)
    {
        if(manguVali[asukoht] != 0)
            return false;
        if(kasmangkäibveel() == true)
            return false;
        manguVali[asukoht] = aktiivneMangija;
        vahetaMangija();
        return true;
    }

    public int getVali(int asukoht)
    {
        return manguVali[asukoht];
    }


    public boolean kasmangkäibveel(){
        // veergude kontroll alla liikumine
        for (int n=1; n<61; n++){
            int ka=0;
            if(manguVali[n] != 0){
            for (int i=n; i<n+50; i=i+10){
                if (manguVali[n]==manguVali[i]){
                    ka++;
                    if(ka==5){
                        voitja=manguVali[i];
                        return true;
                    }
                }
            }
        }
    }
        // veergude kontroll üles liikumine
        for (int n=100; n<41; n--){
            int ka=0;
            if(manguVali[n] != 0){
                for (int i=n; i>n-50; i=i-10){
                    if (manguVali[n]==manguVali[i]){
                        ka++;
                        if(ka==5){
                            voitja=manguVali[i];
                            return true;
                        }
                    }
                }
            }
        }
        // Ridade kontroll paremaleliikumine
        for (int n=1; n<7; n++)
        {

            for (int i=0; i<91; i=i+10)
            {
                int ka=0;
                int z=n+i;
                if(manguVali[z] != 0)
                    {
                    for (int k=i+n; k < i+n+5; k=k+1)
                        {
                            if (manguVali[i+n]==manguVali[k])
                            {
                                ka++;
                                if(ka==5){
                                    voitja=manguVali[i+n];
                                    return true;
                                }
                            }
                        }
                    }
                }
                // paremake poole diagonaal alla

        }
        for (int n=1; n<7; n++)
        {
            for (int i=0; i<57; i=i+10)
            {
                int ias=0;
                if(manguVali[i+n] != 0) {
                for (int k=i+n; k < 101; k=k+11)
                {
                    if(manguVali[i+n]==manguVali[k])
                    ias++;
                    if (ias ==5){
                        voitja=manguVali[i+n];
                        return true;
                    }
                }}
        }}
        // vasakule poole diagonaal alla


        for (int n=10; n>4; n--)
        {
            for (int i=0; i<51; i=i+10)
            {
                int ias=0;
                if(manguVali[i+n] != 0) {
                for (int k=i+n; k < i+n+37; k=k+9)
                {
                    if(manguVali[i+n]==manguVali[k]){
                    ias++;
                    if (ias==5){
                        voitja=manguVali[i+n];
                        return true;
                    }}
                }}
        }

    }







    return false;}

    public String kesvoitis()
    {
        if (voitja==1){
            return "X";
        }
            return "O";
    }


}


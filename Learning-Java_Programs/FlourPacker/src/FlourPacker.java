public class FlourPacker {
    public static boolean canPack(int bigCount, int smallCount, int goal){

if ((bigCount<0)|| (smallCount<0)||(goal<0)){
    return false;
}


      int new_bigCount=5*bigCount;
      int new_smallCount=1*smallCount;



        if ((new_bigCount+new_smallCount)<=goal){
            return true;
        }else if(new_smallCount>goal){
            return true;
        }

        if((new_bigCount<=goal)&&((new_smallCount>=goal) || (new_smallCount<=goal))){
            return true;
        } else{
            return false;
        }
    }
}

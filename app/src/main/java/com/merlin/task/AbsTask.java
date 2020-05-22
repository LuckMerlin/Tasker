package com.merlin.task;

public abstract class AbsTask<T> implements Task<T> {
     private final Status mStatus=new Status(Status.INVALID,null);

     protected final void notifyUpdate(int status,String note,Object arg,Callback ...callbacks){
         mStatus.status(status).note(note).arg(arg);
    }


    public final boolean isStatus(int ...status){
        Status curr=null!=status?mStatus:null;
        if (null!=curr){
            int currStatus=curr.getStatus();
            for (int child:status) {
                if (child==currStatus){
                    return true;
                }
            }
        }
       return false;
    }

    protected Controller onExecute(T arg, Callback... callbacks){
        notifyUpdate(FINISH,"Task finish.",this,callbacks);
        return null;
    }

    @Override
    public final Controller execute(T arg, Callback... callbacks) {
         if (isStatus(FINISH,DOING)){
            Debug.D("Not need execute again while task already finish or doing."+this);
            notifyUpdate(FINISH,"Task already finish or doing.",this,callbacks);
            return null;
         }
         return onExecute(arg,callbacks);
    }

    @Override
    public final Status getStatus() {
        return mStatus;
    }
}

package com.merlin.task;

import java.util.ArrayList;
import java.util.Collection;

public class TaskGroup<M extends Task,T>  extends AbsTask<T>{
    private Collection<M> mList;
    private M mDoing;

    public TaskGroup() {
        super();
    }

    public TaskGroup(int initialCapacity) {
        mList=initialCapacity>=0?new ArrayList<M>(initialCapacity):null;
    }

    public TaskGroup(Collection<? extends M> c) {
        if (null!=c){
            mList=new ArrayList<>(c.size());
            mList.addAll(c);
        }
    }

    @Override
    public final Controller execute(T arg, Callback ...callbacks) {
         M doing=mDoing;
        if (null==doing||isStatus(FINISH,doing.getStatus())){
            doing=onResolveNextUnFinish();
            if (null!=doing&&!isStatus(FINISH,doing.getStatus())){
                mDoing=doing;
                return doing.execute(arg,callbacks);
            }
            Debug.D(getClass(),"None next child resolved."+this);
            notifyUpdate(FINISH,"None next child resolved.",this,callbacks);
            return null;
        }
        Debug.D(getClass(),"Exist doing child."+doing);
        notifyUpdate(FINISH,"Exist doing child.",doing,callbacks);
        return null;
    }

    public final M getDoing() {
        return mDoing;
    }

    M onResolveNextUnFinish(){
        Collection<M> list=mList;
        if (null!=list&&list.size()>0){
            for (M child:list) {
                if (null!=child&&!isStatus(FINISH,child.getStatus())){
                    return child;
                }
            }
        }
        return null;
    }

    public final boolean add(M obj){
        if (null!=obj){
            Collection<M> list=mList;
            synchronized (list=null!=list?list:(mList=new ArrayList<>(1))) {
                return list.add(obj);
            }
        }
        return false;
    }

    public final boolean remove(Object obj){
        Collection<M> list=null!=obj?mList:null;
        if (null!=list){
            synchronized (list){
               return list.remove(obj);
            }
        }
        return false;
    }

    public final M index(Object obj){
        Collection<M> list=mList;
        if (null!=obj&&null!=list){
            synchronized (list){
                for (M child:list) {
                    if (null!=child&&child.equals(obj)){
                        return child;
                    }
                }
            }
        }
        return null;
    }

    public final int size(){
        Collection<M> list=mList;
        if (null!=list){
            synchronized (list){
                return list.size();
            }
        }
        return -1;
    }

}

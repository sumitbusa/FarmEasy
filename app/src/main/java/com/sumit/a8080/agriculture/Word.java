package com.sumit.a8080.agriculture;

/**
 * Created by amd A10 on 20-Jan-17.
 */

public class Word {
    private String mName;
    private String mAddress;
    private String mPhNo;
    public Word(String name,String address,String phoneNo)
    {
        mName=name;
        mPhNo=phoneNo;
        mAddress=address;
    }
    public String getmName()
    {
        return mName;
    }
    public String getAddress()
    {
        return mAddress;
    }
    public String getPhNo(){ return mPhNo; }
}

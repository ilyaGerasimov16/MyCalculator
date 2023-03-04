package com.example.helloworld;

import android.os.Parcel;
import android.os.Parcelable;


public class CurrentSign implements Parcelable {
    Character sign;

    protected CurrentSign(Parcel in) {
        int tmpSign = in.readInt();
        sign = tmpSign != Integer.MAX_VALUE ? (char) tmpSign : null;
    }

    public static final Creator<CurrentSign> CREATOR = new Creator<CurrentSign>() {
        @Override
        public CurrentSign createFromParcel(Parcel in) {
            return new CurrentSign(in);
        }

        @Override
        public CurrentSign[] newArray(int size) {
            return new CurrentSign[size];
        }
    };

    public CurrentSign() {

    }

    public Character getSign() {
        return sign;
    }

    public void setSign(Character sign) {
        this.sign = sign;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(sign != null ? (int) sign : Integer.MAX_VALUE);
    }
}

package com.example.roombookexample;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "books")
public class BookModel implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "title")
    String title;

    @ColumnInfo(name = "author")
    String author;

    public BookModel(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public BookModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(author);
    }

    public static final Parcelable.Creator<BookModel> CREATOR = new Parcelable.Creator<BookModel>() {
        @Override
        public BookModel createFromParcel(Parcel parcel) {
            int id = parcel.readInt();
            String title = parcel.readString();
            String author = parcel.readString();
            return new BookModel(id, title, author);
        }

        @Override
        public BookModel[] newArray(int i) {
            return new BookModel[i];
        }
    };

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}

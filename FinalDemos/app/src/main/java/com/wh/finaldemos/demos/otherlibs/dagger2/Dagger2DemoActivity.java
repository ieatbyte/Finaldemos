package com.wh.finaldemos.demos.otherlibs.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wh.finaldemos.R;

import javax.inject.Inject;

import dagger.Component;

public class Dagger2DemoActivity extends AppCompatActivity {

//    CarShopComponent mCarShopComponent;

    @Inject
    Car mCar;

    @Inject
    Person mPerson;

//    @Component(modules = MakeCarModule.class)
//    public interface CarShopComponent {
//        Car makeCar();
//    }
//
//    @Component(modules = MakeCarModule.class)
//    public interface CarShopComponent2 {
//        void inject(Dagger2DemoActivity activity);
//    }

    @Component(modules = {MakeCarModule.class, BuildPersonModule.class}) // , BuildPersonModule.class
    public interface BuildPersonComponent {
        void inject(Dagger2DemoActivity activity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2_demo);
        Log.e("dagger2", "onCreate start");
        //mCarShopComponent = DaggerCarShopComponent.builder()
//        Car c = DaggerDagger2DemoActivity_CarShopComponent.builder().makeCarModule(new MakeCarModule("my")).build().makeCar();
//        c.getName();
//        Log.e("dagger2", "onCreate done " + c.getName());
//
//        DaggerDagger2DemoActivity_CarShopComponent2.builder().makeCarModule(new MakeCarModule("you")).build().inject(this);
//
//        Log.e("dagger2", "onCreate inject done " + mCar.getName());

        DaggerDagger2DemoActivity_BuildPersonComponent.builder().makeCarModule(new MakeCarModule("him")).buildPersonModule(new BuildPersonModule("jack")).build().inject(this);

        Log.e("dagger2", "onCreate inject person done " + mPerson.getCar().getName() + ", person name:" + mPerson.getName());
    }
}

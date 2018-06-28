package com.example.instavan_pc.demoredbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SeatBookingActivity extends AppCompatActivity
{
    private int totalPrice = 0,totalSeats = 0;
    private boolean seat1 = false,seat2 = false,seat3 = false,seat4 = false,seat5 = false,seat6 = false,seat7 = false,
            seat8 = false,seat9 = false,seat10 = false,seat11 = false,seat12 = false,seat13 = false,seat14 = false,
            seat15 = false,seat16 = false,seat17 = false,seat18 = false,seat19 = false,seat20 = false,seat21 = false,
            seat22 = false,seat23 = false,seat24 = false,seat25 = false,seat26 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_booking);

//        ImageView imageView = (ImageView) SeatBookingActivity.this.findViewById(R.id.seat1);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }


    public void changeImagePrice1(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat1);
        if(seat1 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat1 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat1 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat1 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice2(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat2);
        if(seat2 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat2 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat2 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat2 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }

    public void changeImagePrice3(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat3);
        if(seat3 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat3 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat3 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat3 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice4(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat4);
        if(seat4 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat4 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat4 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat4 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice5(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat5);
        if(seat5 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat5 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat5 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat5 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice6(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat6);
        if(seat6 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat6 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat6 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat6 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice7(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat7);
        if(seat7 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat7 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat7 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat7 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice8(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat8);
        if(seat8 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat8 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat8 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat8 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice9(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat9);
        if(seat9 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat9 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat9 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat9 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice10(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat10);
        if(seat10 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat10 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat10 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat10 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice11(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat11);
        if(seat11 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat11 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat11 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat11 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice12(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat12);
        if(seat12 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat12 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat12 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat12 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice13(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat13);
        if(seat13 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat13 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat13 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat13 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice14(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat14);
        if(seat14 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat14 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat14 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat14 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice15(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat15);
        if(seat15 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat15 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat15 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat15 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice16(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat16);
        if(seat16 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat16 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat16 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat16 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice17(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat17);
        if(seat17 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat17 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat17 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat17 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice18(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat18);
        if(seat18 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat18 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat18 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat18 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice19(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat19);
        if(seat19 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat19 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat19 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat19 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice20(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat20);
        if(seat20 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat20 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat20 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat20 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice21(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat21);
        if(seat21 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat21 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat21 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat21 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice22(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat22);
        if(seat22 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat22 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat22 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat22 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice23(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat23);
        if(seat23 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat23 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat23 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat23 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice24(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat24);
        if(seat24 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat24 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat24 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat24 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice25(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat25);
        if(seat25 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat25 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat25 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat25 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
    public void changeImagePrice26(View view)
    {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView iv =   (ImageView)  this.findViewById(R.id.seat26);
        if(seat26 == false)
        {
            iv.setImageResource(R.drawable.selectedseat);
            seat26 = true ;
            totalSeats++;
            totalPrice += 1500;
        }
        else if(seat26 == true)
        {
            iv.setImageResource(R.drawable.emptyseat);
            seat26 = false ;
            totalSeats--;
            totalPrice -= 1500;
        }
        TextView textViewSeats = (TextView) SeatBookingActivity.this.findViewById(R.id.totalSeats);
        textViewSeats.setText("Total Selected Seats : " + totalSeats);

        TextView textViewPrice = (TextView) SeatBookingActivity.this.findViewById(R.id.totalPrice);
        textViewPrice.setText("Total Price                  : " + totalPrice);

    }
}

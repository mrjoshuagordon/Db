package com.jh.db;


//This will be used to create a dialog window

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.Toast;

//If you get an error that the minimum must be 11, change the minimum in the manifest
//and also change it in build.gradle

//To generate the onCreateDialog() right click on DialogFragment and Generate and
//select onCreateDialog()

public class MyDialogFragment extends DialogFragment{
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {

   // We build the dialog
   // getActivity() returns the Activity this Fragment is associated with
   AlertDialog.Builder theDialog = new AlertDialog.Builder(getActivity());

   // Set the title for the Dialog
   theDialog.setTitle("About");

   // Set the message
   theDialog.setMessage("This app is best used in conjunction with MyFitnessPal. Thanks for your support.");

  // theDialog.setMessage(Html.fromHtml("<p>Sample text, <a href=\"http://google.nl\">hyperlink</a>.</p>"));
  // theDialog.show();
  //theDialog.setMovementMethod(LinkMovementMethod.getInstance());
   
   // Add text for a positive button
   theDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
       @Override
       public void onClick(DialogInterface dialogInterface, int i) {

        //   Toast.makeText(getActivity(), "Clicked OK", Toast.LENGTH_SHORT).show();

       }
   });

   // Add text for a negative button
   theDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
       @Override
       public void onClick(DialogInterface dialogInterface, int i) {

       //    Toast.makeText(getActivity(), "Clicked Cancel", Toast.LENGTH_SHORT).show();

       }
   });

   // Returns the created dialog
   return theDialog.create();

}
}
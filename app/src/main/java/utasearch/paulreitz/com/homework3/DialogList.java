package utasearch.paulreitz.com.homework3;



        import android.app.AlertDialog;
        import android.app.Dialog;
        import android.app.DialogFragment;
        import android.content.DialogInterface;
        import android.os.Bundle;
        import android.widget.Toast;

public class DialogList extends DialogFragment {
    String colorsArray[] = {"RED", "BLUE", "GREEN", "PURPLE"};

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick Color")
                .setItems(colorsArray, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "You clicked " + colorsArray[which], Toast.LENGTH_SHORT).show();
                    }
                });

        return builder.create();
    }
}





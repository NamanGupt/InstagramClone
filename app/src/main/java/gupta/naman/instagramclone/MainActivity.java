package gupta.naman.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edtName,edtPunchSpeed,edtPunchPower,edtKickSpeed,edtKickPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName=findViewById(R.id.edtn);
        edtPunchSpeed=findViewById(R.id.editps);
        edtPunchPower=findViewById(R.id.editpp);
        edtKickSpeed=findViewById(R.id.editks);
        edtKickPower=findViewById(R.id.editkp);

        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ParseObject submit=new ParseObject("submit");
                submit.put("name",edtName.getText().toString());
                submit.put("PunchSpeed",edtPunchSpeed.getText().toString());
                submit.put("PunchPower",edtPunchPower.getText().toString());
                submit.put("KickSpeed",edtKickSpeed.getText().toString());
                submit.put("KickPower",edtKickPower.getText().toString());
                submit.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null)
                            FancyToast.makeText(MainActivity.this,edtName.getText()+" is saved in server",FancyToast.LENGTH_LONG,FancyToast.DEFAULT,false).show();
                        else
                            FancyToast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG,FancyToast.ERROR,false).show();

                    }
                });
            }
        });


    }


    }


package gupta.naman.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn,btn2;
    EditText edtName,edtPunchSpeed,edtPunchPower,edtKickSpeed,edtKickPower;
    TextView tv;
    String all;

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
//TO RETRIEVE DATA FROM SERVER
        tv=findViewById(R.id.textView);
        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> parse=ParseQuery.getQuery("submit");
                parse.getInBackground("Gaeokvcgip", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {
                        if(object!=null && e==null)
                        {
                            tv.setText(object.get("name").toString()+"Punch Speed"+object.get("PunchSpeed"));
                        }
                    }
                });
            }
        });

        //to retrieve all objects at once
        btn2=findViewById(R.id.button);
        all="";
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> parseAll=ParseQuery.getQuery("submit");
                parseAll.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if(e==null)
                        {
                            if(objects.size()>0)
                            {
                                for(ParseObject p:objects)
                                {
                                    all+=p.get("name")+"\n";
                                }

                            }
                            FancyToast.makeText(MainActivity.this,all,Toast.LENGTH_LONG,FancyToast.SUCCESS,false).show();

                        }
                    }
                });
            }
        });


    }


    }


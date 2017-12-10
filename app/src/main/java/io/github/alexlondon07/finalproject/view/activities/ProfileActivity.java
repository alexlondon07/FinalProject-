package io.github.alexlondon07.finalproject.view.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.User;

import java.io.File;

import io.github.alexlondon07.finalproject.R;
import io.github.alexlondon07.finalproject.helper.Constants;
import io.github.alexlondon07.finalproject.helper.Permissions;
import retrofit2.Call;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private TwitterLoginButton twitterLoginButton;
    private ImageView profilePhoto;
    private TextView username, name, tweets, followers, followings;
    private ImageButton imageButtonChangePhotoTwitter;
    private BottomSheetDialog bottomSheetDialog;

    private ImageButton imageButtonGallery;
    private File photoFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Twitter.initialize(this);
        setContentView(R.layout.activity_profile);
        loadView();
        setListener();
        loginTwitter(this);
    }

    private void setListener() {
        //Change php profile
        imageButtonChangePhotoTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog.show();
            }
        });
    }

    private void loadView() {
        twitterLoginButton = findViewById(R.id.login_twitter);
        profilePhoto = findViewById(R.id.session_photo);
        username = findViewById(R.id.session_nickname);
        name = findViewById(R.id.session_name_user);
        tweets = findViewById(R.id.session_likes);
        followers = findViewById(R.id.session_followers);
        followings = findViewById(R.id.session_following);
        imageButtonChangePhotoTwitter = findViewById(R.id.imageButton_change_photo);
        showCustomDialog();
    }

    private void showGallery() {
        if(Permissions.isGrantedPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            showGalleryIntent();
        }else{
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
            Permissions.verifyPermissions(this, permissions);
        }
    }

    private void showGalleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        if(Build.VERSION.SDK_INT < Constants.GALLERY_KIT_KAT){
            startActivityForResult(intent, Constants.GALLERY_KIT_KAT);
        }else {
            String[] type = {"image/*"};
            intent.putExtra(Intent.EXTRA_MIME_TYPES, type);
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            startActivityForResult(intent, Constants.GALLERY);
        }
    }


    /**
     * Metódo para realizar el proceso de Login con Twitter
     * @param context
     */
    private void loginTwitter(final Context context) {

        twitterLoginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                TwitterSession twitterSession = TwitterCore.getInstance().getSessionManager().getActiveSession();

                TwitterAuthToken authToken = twitterSession.getAuthToken();
                Call<User> userResult = TwitterCore.getInstance()
                        .getApiClient(twitterSession)
                        .getAccountService()
                        .verifyCredentials(true, true, true);

                userResult.enqueue(new Callback<User>() {
                    @Override
                    public void success(Result<User> result) {

                        Picasso.with(context)
                                .load(result.data.profileImageUrlHttps)
                                .resize(140, 150)
                                .centerCrop()
                                .into(profilePhoto);

                        username.setText(result.data.screenName);
                        name.setText(result.data.name);
                        tweets.setText(""+result.data.statusesCount);
                        followers.setText(""+result.data.followersCount);
                        followings.setText(""+result.data.friendsCount);

                        hideButtonLoginTwitter();
                    }

                    @Override
                    public void failure(TwitterException exception) {
                            Toast.makeText(ProfileActivity.this, exception.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
            @Override
            public void failure(TwitterException exception) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        twitterLoginButton.onActivityResult(requestCode,resultCode,data);
    }
    public void showButtonLoginTwitter(View button) {
        if (twitterLoginButton.getVisibility() == View.GONE){
            twitterLoginButton.setVisibility(View.VISIBLE);
        }
    }

    public void hideButtonLoginTwitter(){
        if (twitterLoginButton.getVisibility() == View.VISIBLE){
            twitterLoginButton.setVisibility(View.GONE);
        }
    }

    /**
     * Metódo para desplegar las opciones de Galeria y Camara
     */
    private void showCustomDialog() {
        View view = getLayoutInflater().inflate(R.layout.bottomsheet, null);
        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.setCancelable(true);

        //Gallery
        imageButtonGallery = view.findViewById(R.id.button_gallery);
        imageButtonGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGallery();
            }
        });
    }

}

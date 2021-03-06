package com.lexandera.mosembro.dialogs;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;

import com.lexandera.mosembro.Mosembro;
import com.lexandera.raceg.R;

public class SettingsDialog extends Dialog
{
    public SettingsDialog(final Mosembro browser)
    {
        super(browser);
        final SettingsDialog dialog = this;
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.settings_dialog);
        
        final CheckBox enableContentRewritingCbox = (CheckBox)findViewById(R.id.enable_content_rewriting);
        enableContentRewritingCbox.setChecked(browser.getEnableContentRewriting());
        
        Button saveBtn = (Button)findViewById(R.id.settings_save);
        saveBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg0)
            {
                browser.setEnableContentRewriting(enableContentRewritingCbox.isChecked());
                
                browser.savePreferences();
                dialog.dismiss();
            }
        });
    }
}

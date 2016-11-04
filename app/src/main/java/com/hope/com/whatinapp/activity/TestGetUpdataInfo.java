package com.hope.com.whatinapp.activity;

import android.test.AndroidTestCase;

import com.hope.com.whatinapp.R;
import com.hope.com.whatinapp.domain.UpdateInfo;
import com.hope.com.whatinapp.utils.UpdateManager;


public class TestGetUpdataInfo extends AndroidTestCase {

	
	public void testGetInfo() throws Exception{
		UpdateManager service = new UpdateManager(getContext());
		UpdateInfo info = service.getUpdateInfo(R.string.updateurl);
		assertEquals("2.0", info.getVersion());
	}
}

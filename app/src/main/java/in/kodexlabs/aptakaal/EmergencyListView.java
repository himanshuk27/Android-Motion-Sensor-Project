package in.kodexlabs.aptakaal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class EmergencyListView extends DialogFragment {

    private String[] listitems = {"Baidynath Memorial Hospital", "Pradyumn Bal Memorial",
    "Kaling Hospital", "Vimlata hospital", "Care Hospitals", "Care Hospitals"};
    private ListView listView;

    public EmergencyListView() {}

    public static EmergencyListView newInstance(String email) {
        EmergencyListView fragment = new EmergencyListView();
        Bundle args = new Bundle();
        args.putString("Email", email);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_emergency_list_view, container, false);

        listView = (ListView) rootView.findViewById(R.id.list);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, listitems);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:8235365517"));
                startActivity(intent);
            }
        });


        return rootView;
    }
}

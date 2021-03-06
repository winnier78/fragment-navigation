package be.hcpl.android.fragment.navigation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import be.hcpl.android.fragment.navigation.MainActivity;
import be.hcpl.android.fragment.navigation.R;

/**
 * An example fragment that can be loaded in place
 */
public class SecondFragment extends TemplateFragment {

    public static SecondFragment createInstance() {
        return new SecondFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // this is how we load a specific layout
        return inflater.inflate(R.layout.first_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // and here our view is loaded

        ((TextView) view.findViewById(R.id.txtOnTop)).setText(new StringBuilder("You're now on ").append(this.getClass().getSimpleName()).toString());

        view.findViewById(R.id.btnFirstFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).switchContent(FirstFragment.createInstance());
            }
        });
        view.findViewById(R.id.btnSecondFragment).setEnabled(false);
        view.findViewById(R.id.btnThirdFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).switchContent(ThirdFragment.createInstance());
            }
        });
    }
}

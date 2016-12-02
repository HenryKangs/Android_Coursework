package com.example.gear7_000.android_coursework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] buildingNames;
    private String[] buildingDetails;
    public static final String INFO_ONE = "Building info";

    public static int[] buildingPhotos = {
            R.drawable.alanberry,
            R.drawable.alma,
            R.drawable.armstrongsiddeley,
            R.drawable.bugatti,
            R.drawable.carpark,
            R.drawable.charlesward,
            R.drawable.ecbuilding,
            R.drawable.ellenterry,
            R.drawable.fredericlibrary,
            R.drawable.georgeeliot,
            R.drawable.grahamsutherland,
            R.drawable.jaguar,
            R.drawable.jamesstarley,
            R.drawable.mauricefoss,
            R.drawable.priorybuilding,
            R.drawable.richardcrossman,
            R.drawable.sirjohnlaing,
            R.drawable.sirwilliamlyons,
            R.drawable.studentcentre,
            R.drawable.thehub,
            R.drawable.whitefriars,
            R.drawable.williammorris,
            R.drawable.coventryuniversity
    };

    private ArrayList<Building> buildings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildingNames = getResources().getStringArray(R.array.buildingNames);
        buildingDetails = getResources().getStringArray(R.array.buildingDetails);
        generateBuildings();

        listView = (ListView) findViewById(R.id.listViewComplexBuilding);
        listView.setAdapter(new BuildingAdapter(this, R.layout.list_building_item, buildings));
        listView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intentDisplay = new Intent();
                        Bundle bundle = new Bundle();
                        if (position == 0) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "This was constructed in 1963 and has a prominent position on our campus overlooking University Square.  This building is used by our Business Development, Registry and the Vice Chancellors Office. This was named after Alan Berry who was the Director and Chief Executive for the West Midlands Engineering Employers’ Association.");
                        } else if (position == 1) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "This was built in the 1920’s and is the home of our professional services such as Estates, HR and Finance. This was the site of the Singer Works, out of which the Singer Penny Farthing was born and it also holds the origins to Coventry City Football Club.");
                        } else if (position == 2) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "This is the location of our Coventry University College which opened in 2012, offering a new concept in HE, designed to integrate study into your life. The building was built in the 1970’s and is named after the Coventry based engineering group  that operated during the first half of the 20th Century. They were renowned for the design and build of cars, aero-engines and aircraft and were absorbed into Rolls-Royce in 1966.");
                        } else if (position == 3) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "This building funded by the Bugatti trust was built in 2002 and provides a valuable space for our Faculty of Arts and Humanities. In particular this is used in the areas of Automotive & Transport Design with very strong industry links.");
                        } else if (position == 4) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "Built in the 1950’s this building is used mainly by our Faculty of Health and Life Sciences. The building was named after a key figure for the University, who was a University Governor, and became Vice Chair of the Board of Governors in 1982.");
                        } else if (position == 5) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "This building was completed in 2012 and is used solely by our Faculty of Engineering, Environment and Computing. The £55m project delivered a highly sustainable building that uses a range of technologies including rainwater harvesting, solar thermal energy and biomass boilers. Facilities include a high precision wind-tunnel, a £3m high-performance engineering centre, a Harrier Jump Jet, three flight simulators and the UK’s largest magnet.");
                        } else if (position == 6) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "This building is used by our Faculty of Arts and Humanities, specifically for the Performing Arts, Media and Music Students. Fittingly this building previously was a cinema, originally built in 1880 with a major refurbishment in 2000. The building has been named after Dame Ellen Terry, a star of the Victoria stage and a leading Shakespearean actress.");
                        } else if (position == 7) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "This modern and striking building houses the main University library, and was completed in 2001. It has been named after the Coventry based designer of the first British petrol-driven car. With a number of different study zones across 5 floors, it provides an invaluable central study and resource space for staff and students. It is equipped with over 350 computers, group and individual study rooms, books, journals, and electronic resources.");
                        } else if (position == 8) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "This building was built in 1960 and is used solely by our Faculty of Business and Law. George Eliot is the pen name of the novelist Mary Anne Evans (1819-1880) and was one of the leading writers of the Victorian era.");
                        } else if (position == 9) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "Built in 1959, this building is used by our Faculty of Arts and Humanities, predominately for the Design and Visual Art students, fitted with a full commercial fashion studio. This building was aptly named after the painter and print maker who created the world famous tapestry Christ in Glory hanging in Coventry Cathedral.");
                        } else if (position == 10) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "Completed in 2011 TheHub is a modern, hi-tech building providing a welcoming social space for our students. Facilities in the building include a doctors’ surgery, a multi-cultural faith centre, employment services, catering services, as well as hairdressers, food court and the Students’ Union offices. This building also has a large fully licensed function space with bars and a multi-purpose venue space. The building achieved a BREEAM status of Excellent.");
                        } else if (position == 11) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "This building was built in the late 1970’s and sponsored by the Coventry based car manufacturer. It has recently undergone a significant refurbishment, with additional improvements planned.  It is now home to our Postgraduate students, as well as our researchers within the Centre for Business in Society (CBiS). ");
                        } else if (position == 12) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "Built in the late 1950’s, this is home to our Faculty of Health and Life Sciences. It was named after the British inventor of the Coventry tricycle and father of the bicycle industry.");
                        } else if (position == 13) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "Built in 1978, this building is used by our Faculty of Arts and Humanities, who mainly run their Industrial Design courses from here. The building has been named after the former Deputy Director of Coventry Polytechnic and one of the University’s Honorary Life Fellows.");
                        } else if (position == 14) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "This is our impressive Multi-storey car park, opened for staff and visitors in 2010. It has 457 spaces over 15 floors, including spaces for electric vehicles.");
                        } else if (position == 15) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "Built in 1964, this building is occupied by the Cambridge Education Group, who run their Foundation Campus from here. They offer University Pathway courses for foreign students who wish to gain entry to UK Universities. Also in this building is a large sports hall, and the University’s Student Union Radio.");
                        } else if (position == 16) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "This was built in 1971 and has been named after the political journalist and Labour politician, representing Coventry East from 1945-1974. This is the main building for the Faculty of Health and Life Sciences and includes a mock hospital ward and operating theatre, complete with sink scrubs and theatre lights.");
                        } else if (position == 17) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "This building was built in 1970, and was named after the knighted British entrepreneur in the construction industry. This building is primarily used by the Faculty of Engineering, Environment and Computing, offering courses relating to the construction industry.");
                        } else if (position == 18) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "Constructed in1980, this building is home to our IT services. Sir William Lyons was the co-founder of the Swallow Sidecar Company which subsequently became Jaguar Cars Limited.");
                        } else if (position == 19) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "Construction was completed in 2006, and as its name suggests is home to some key student services as well as our International Office. This is where our students enroll as well as the main information point for student accommodation and finance queries.");
                        } else if (position == 20) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "This is a small office used by our Faculty of Health and Life Sciences. Built in 1922 and its name is drawn from the Carmelite Friary founded in 1342 in Coventry.");
                        } else if (position == 21) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.BuildingDisplayInfo");
                            intentDisplay.putExtra(INFO_ONE, "This building began life in 1910 as a factory and has been named after the founder of the Morris car company who used this building as part of its engine production unit. It was converted for use by the University and is now occupied by our Faculty of Business and Law.");
                        } else if (position == 22) {
                            intentDisplay.setAction("com.example.gear7_000.android_coursework.StudentActivity");
                        }
                        intentDisplay.putExtras(bundle);
                        startActivity(intentDisplay);
                    }
                }
        );
    }

    private void generateBuildings() {
        for (int i = 0; i < buildingPhotos.length; i++) {
            buildings.add(new Building(buildingNames[i], buildingDetails[i], buildingPhotos[i]));
        }
    }

    //public void goDisplay(View v) {
    //Intent intentDisplay = new Intent();
    //intentDisplay.setAction("com.example.kangj10.mylist");
    //Bundle bundle = new Bundle();
    //bundle.putString(KEY_COLOR, editTextColor.getText().toString());
    //bundle.putString(KEY_NOTE, editTextNote.getText().toString());
    //intentDisplay.putExtras(bundle);
    //startActivity(intentDisplay);
    //}
}
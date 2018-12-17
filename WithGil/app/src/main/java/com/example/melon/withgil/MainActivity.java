package com.example.melon.withgil;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.robertlevonyan.views.customfloatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;

    private void initData(MapInfoDatabase mapInfoDatabase, LocationInfoDatabase locationInfoDatabase){
        mapInfoDatabase.addRegion(1,"중부", "장충파출소1");
        mapInfoDatabase.addRegion(2,"중부", "약수지구대1");
        mapInfoDatabase.addRegion(3,"중부", "광희지구대1");
        mapInfoDatabase.addRegion(4,"중부", "약수지구대1");
        mapInfoDatabase.addRegion(5,"중부", "약수지구대2");
        mapInfoDatabase.addRegion(6,"중부", "약수지구대3");
        mapInfoDatabase.addRegion(7,"중부", "약수지구대4");
        mapInfoDatabase.addRegion(8,"중부", "신당파출소1");
        mapInfoDatabase.addRegion(9,"중부", "장충파출소2");
        mapInfoDatabase.addRegion(10,"중부", "신당파출소2");
        mapInfoDatabase.addRegion(11,"중부", "충무파출소1");
        mapInfoDatabase.addRegion(12,"중부", "충무파출소2");
        mapInfoDatabase.addRegion(13,"중부", "을지지구대1");
        mapInfoDatabase.addRegion(14,"중부", "을지지구대2");
        mapInfoDatabase.addRegion(54,"용산", "원효지구대1");
        mapInfoDatabase.addRegion(55,"용산", "원효지구대2");
        mapInfoDatabase.addRegion(56,"용산", "용중지구대1");
        mapInfoDatabase.addRegion(57,"용산", "용중지구대2");
        mapInfoDatabase.addRegion(58,"용산", "용중지구대3");
        mapInfoDatabase.addRegion(59,"용산", "이태원파출소1");
        mapInfoDatabase.addRegion(60,"용산", "한남파출소1");
        mapInfoDatabase.addRegion(61,"용산", "한남파출소2");
        mapInfoDatabase.addRegion(62,"용산", "한남파출소3");
        mapInfoDatabase.addRegion(63,"용산", "보광파출소1");
        mapInfoDatabase.addRegion(64,"용산", "보광파출소2");
        mapInfoDatabase.addRegion(65,"용산", "보광파출소3");
        mapInfoDatabase.addRegion(66,"용산", "보광파출소4");
        mapInfoDatabase.addRegion(67,"용산", "용산역파출소1");
        mapInfoDatabase.addRegion(68,"용산", "한강로파출소1");
        mapInfoDatabase.addRegion(69,"용산", "한강로파출소2");
        mapInfoDatabase.addRegion(70,"용산", "이촌파출소1");
        mapInfoDatabase.addRegion(293,"강서", "화곡지구대1");
        mapInfoDatabase.addRegion(294,"강서", "화곡지구대2");
        mapInfoDatabase.addRegion(295,"강서", "화곡지구대3");
        mapInfoDatabase.addRegion(296,"강서", "곰달래지구대1");
        mapInfoDatabase.addRegion(297,"강서", "곰달래지구대2");
        mapInfoDatabase.addRegion(298,"강서", "곰달래지구대3");
        mapInfoDatabase.addRegion(299,"강서", "공항지구대1");
        mapInfoDatabase.addRegion(300,"강서", "공항지구대2");
        mapInfoDatabase.addRegion(301,"강서", "공항지구대3");
        mapInfoDatabase.addRegion(302,"강서", "까치산지구대1");
        mapInfoDatabase.addRegion(303,"강서", "까치산지구대2");
        mapInfoDatabase.addRegion(304,"강서", "까치산지구대3");
        mapInfoDatabase.addRegion(305,"강서", "발산파출소1");
        mapInfoDatabase.addRegion(306,"강서", "발산파출소2");
        mapInfoDatabase.addRegion(307,"강서", "염창파출소1");
        mapInfoDatabase.addRegion(308,"강서", "염창파출소2");
        mapInfoDatabase.addRegion(309,"강서", "염창파출소3");
        mapInfoDatabase.addRegion(310,"강서", "화곡3파출소1");
        mapInfoDatabase.addRegion(311,"강서", "화곡3파출소2");
        mapInfoDatabase.addRegion(312,"강서", "등촌2파출소1");
        mapInfoDatabase.addRegion(313,"강서", "등촌2파출소2");
        mapInfoDatabase.addRegion(314,"강서", "등촌2파출소3");
        mapInfoDatabase.addRegion(315,"강서", "방화3파출소1");
        mapInfoDatabase.addRegion(316,"강서", "방화3파출소2");
        mapInfoDatabase.addRegion(439,"은평", "불광지구대1");
        mapInfoDatabase.addRegion(440,"은평", "불광지구대2");
        mapInfoDatabase.addRegion(441,"은평", "불광지구대3");
        mapInfoDatabase.addRegion(442,"은평", "연신내지구대1");
        mapInfoDatabase.addRegion(443,"은평", "연신내지구대2");
        mapInfoDatabase.addRegion(444,"은평", "연신내지구대3");
        mapInfoDatabase.addRegion(445,"은평", "역촌파출소1");
        mapInfoDatabase.addRegion(446,"은평", "역촌파출소2");
        mapInfoDatabase.addRegion(447,"은평", "대조파출소1");
        mapInfoDatabase.addRegion(448,"은평", "대조파출소2");
        mapInfoDatabase.addRegion(449,"은평", "대조파출소3");

        mapInfoDatabase.addRegion(29, "서대문", "충정로지구대1");
        mapInfoDatabase.addRegion(30, "서대문", "충정로지구대2");
        mapInfoDatabase.addRegion(31, "서대문", "신촌지구대1");
        mapInfoDatabase.addRegion(32, "서대문", "신촌지구대2");
        mapInfoDatabase.addRegion(33, "서대문", "홍은파출소1");
        mapInfoDatabase.addRegion(34, "서대문", "홍은파출소2");
        mapInfoDatabase.addRegion(35, "서대문", "연희지구대1");
        mapInfoDatabase.addRegion(36, "서대문", "연희지구대2");
        mapInfoDatabase.addRegion(37, "서대문", "남가좌파출소1");
        mapInfoDatabase.addRegion(38, "서대문", "남가좌파출소2");
        mapInfoDatabase.addRegion(39, "서대문", "북가좌파출소1");
        mapInfoDatabase.addRegion(40, "서대문", "북가좌파출소2");
        mapInfoDatabase.addRegion(41, "서대문", "홍제파출소1");
        mapInfoDatabase.addRegion(42, "서대문", "홍제파출소2");
        mapInfoDatabase.addRegion(43, "서대문", "홍은2파출소1");
        mapInfoDatabase.addRegion(44, "서대문", "홍은2파출소2");
        mapInfoDatabase.addRegion(45, "혜화", "혜화파출소1");
        mapInfoDatabase.addRegion(46, "혜화", "창신파출소1");
        mapInfoDatabase.addRegion(47, "혜화", "명륜파출소1");
        mapInfoDatabase.addRegion(48, "혜화", "대학로파출소1");
        mapInfoDatabase.addRegion(49, "혜화", "창신파출소2");
        mapInfoDatabase.addRegion(50, "혜화", "덕산파출소1");
        mapInfoDatabase.addRegion(51, "혜화", "명륜파출소2");
        mapInfoDatabase.addRegion(52, "혜화", "창신파출소2");
        mapInfoDatabase.addRegion(53, "혜화", "덕산파출소2");
        mapInfoDatabase.addRegion(105, "마포", "공덕지구대1");
        mapInfoDatabase.addRegion(106, "마포", "공덕지구대2");
        mapInfoDatabase.addRegion(107, "마포", "용강지구대1");
        mapInfoDatabase.addRegion(108, "마포", "용강지구대2");
        mapInfoDatabase.addRegion(109, "마포", "서강지구대1");
        mapInfoDatabase.addRegion(110, "마포", "서강지구대2");
        mapInfoDatabase.addRegion(111, "마포", "서강지구대3");
        mapInfoDatabase.addRegion(112, "마포", "홍익지구대1");
        mapInfoDatabase.addRegion(113, "마포", "홍익지구대2");
        mapInfoDatabase.addRegion(114, "마포", "홍익지구대3");
        mapInfoDatabase.addRegion(115, "마포", "월드컵지구대1");
        mapInfoDatabase.addRegion(116, "마포", "월드컵지구대2");
        mapInfoDatabase.addRegion(117, "마포", "연남파출소1");
        mapInfoDatabase.addRegion(118, "마포", "연남파출소2");
        mapInfoDatabase.addRegion(119, "마포", "연남파출소3");
        mapInfoDatabase.addRegion(120, "마포", "망원파출소1");
        mapInfoDatabase.addRegion(121, "마포", "망원파출소2");
        mapInfoDatabase.addRegion(122, "마포", "상암파출소1");

        locationInfoDatabase.addLocation(1, 37.559089, 127.002899);
        locationInfoDatabase.addLocation(1, 37.559000, 127.002757);
        locationInfoDatabase.addLocation(1, 37.558919, 127.002390);
        locationInfoDatabase.addLocation(1, 37.558699, 127.002040);
        locationInfoDatabase.addLocation(1, 37.558714, 127.001814);
        locationInfoDatabase.addLocation(1, 37.558936, 127.001486);
        locationInfoDatabase.addLocation(1, 37.559050, 127.001458);
        locationInfoDatabase.addLocation(1, 37.559252, 127.001496);
        locationInfoDatabase.addLocation(1, 37.559422, 127.001337);
        locationInfoDatabase.addLocation(1, 37.559561, 127.000495);
        locationInfoDatabase.addLocation(1, 37.559214, 127.000358);
        locationInfoDatabase.addLocation(1, 37.558988, 127.000421);
        locationInfoDatabase.addLocation(1, 37.558861, 127.000460);
        locationInfoDatabase.addLocation(1, 37.558750, 127.000650);
        locationInfoDatabase.addLocation(1, 37.558736, 127.000880);
        locationInfoDatabase.addLocation(1, 37.558596, 127.001291);
        locationInfoDatabase.addLocation(1, 37.558495, 127.001757);
        locationInfoDatabase.addLocation(1, 37.558491, 127.002123);
        locationInfoDatabase.addLocation(1, 37.558838, 127.002475);
        locationInfoDatabase.addLocation(2, 37.557245, 127.012003);
        locationInfoDatabase.addLocation(2, 37.557296, 127.011654);
        locationInfoDatabase.addLocation(2, 37.557407, 127.009744);
        locationInfoDatabase.addLocation(2, 37.557628, 127.009245);
        locationInfoDatabase.addLocation(2, 37.557509, 127.008779);
        locationInfoDatabase.addLocation(3, 37.562082, 127.014788);
        locationInfoDatabase.addLocation(3, 37.562379, 127.013961);
        locationInfoDatabase.addLocation(3, 37.564267, 127.010442);
        locationInfoDatabase.addLocation(3, 37.564319, 127.010217);
        locationInfoDatabase.addLocation(4, 37.551601, 127.008646);
        locationInfoDatabase.addLocation(4, 37.552966, 127.009451);
        locationInfoDatabase.addLocation(4, 37.553110, 127.009504);
        locationInfoDatabase.addLocation(5, 37.554346, 127.010366);
        locationInfoDatabase.addLocation(5, 37.555077, 127.008977);
        locationInfoDatabase.addLocation(5, 37.555112, 127.008639);
        locationInfoDatabase.addLocation(6, 37.558113, 127.012539);
        locationInfoDatabase.addLocation(6, 37.557021, 127.015516);
        locationInfoDatabase.addLocation(7, 37.556164, 127.011445);
        locationInfoDatabase.addLocation(7, 37.555917, 127.012222);
        locationInfoDatabase.addLocation(7, 37.555432, 127.013521);
        locationInfoDatabase.addLocation(7, 37.555930, 127.013848);
        locationInfoDatabase.addLocation(8, 37.563241, 127.019244);
        locationInfoDatabase.addLocation(8, 37.564104, 127.016014);
        locationInfoDatabase.addLocation(9, 37.562100, 127.006417);
        locationInfoDatabase.addLocation(9, 37.562304, 127.006036);
        locationInfoDatabase.addLocation(9, 37.562423, 127.005634);
        locationInfoDatabase.addLocation(9, 37.562500, 127.004776);
        locationInfoDatabase.addLocation(9, 37.562436, 127.003928);
        locationInfoDatabase.addLocation(9, 37.562385, 127.002651);
        locationInfoDatabase.addLocation(10, 37.561215, 127.018063);
        locationInfoDatabase.addLocation(10, 37.564013, 127.019726);
        locationInfoDatabase.addLocation(10, 37.565586, 127.019683);
        locationInfoDatabase.addLocation(11, 37.558601, 126.996062);
        locationInfoDatabase.addLocation(11, 37.558525, 126.996953);
        locationInfoDatabase.addLocation(11, 37.559112, 126.996738);
        locationInfoDatabase.addLocation(11, 37.559243, 126.996604);
        locationInfoDatabase.addLocation(11, 37.559469, 126.996717);
        locationInfoDatabase.addLocation(11, 37.559652, 126.997006);
        locationInfoDatabase.addLocation(11, 37.560762, 126.996738);
        locationInfoDatabase.addLocation(11, 37.560974, 126.996840);
        locationInfoDatabase.addLocation(11, 37.561178, 126.997259);
        locationInfoDatabase.addLocation(11, 37.561484, 126.997350);
        locationInfoDatabase.addLocation(11, 37.561748, 126.997382);
        locationInfoDatabase.addLocation(11, 37.561952, 126.997339);
        locationInfoDatabase.addLocation(12, 37.557959, 126.995661);
        locationInfoDatabase.addLocation(12, 37.558682, 126.995458);
        locationInfoDatabase.addLocation(12, 37.558809, 126.995420);
        locationInfoDatabase.addLocation(12, 37.560287, 126.995393);
        locationInfoDatabase.addLocation(12, 37.560461, 126.994924);
        locationInfoDatabase.addLocation(12, 37.560776, 126.993551);
        locationInfoDatabase.addLocation(12, 37.560993, 126.993277);
        locationInfoDatabase.addLocation(13, 37.566715, 126.999127);
        locationInfoDatabase.addLocation(13, 37.567251, 126.999095);
        locationInfoDatabase.addLocation(13, 37.568688, 126.999009);
        locationInfoDatabase.addLocation(13, 37.568879, 126.998960);
        locationInfoDatabase.addLocation(14, 37.563032, 127.001811);
        locationInfoDatabase.addLocation(14, 37.563368, 127.001726);
        locationInfoDatabase.addLocation(14, 37.564522, 127.001654);
        locationInfoDatabase.addLocation(54, 37.546813, 126.964995);
        locationInfoDatabase.addLocation(54, 37.546430, 126.965714);
        locationInfoDatabase.addLocation(54, 37.546540, 126.966786);
        locationInfoDatabase.addLocation(54, 37.546302, 126.967495);
        locationInfoDatabase.addLocation(54, 37.545639, 126.967001);
        locationInfoDatabase.addLocation(54, 37.544822, 126.966883);
        locationInfoDatabase.addLocation(55, 37.544108, 126.966701);
        locationInfoDatabase.addLocation(55, 37.543852, 126967945);
        locationInfoDatabase.addLocation(55, 37.543640, 126.968557);
        locationInfoDatabase.addLocation(55, 37.543572, 126.969152);
        locationInfoDatabase.addLocation(55, 37.543559, 126.969442);
        locationInfoDatabase.addLocation(55, 37.543623, 126.969839);
        locationInfoDatabase.addLocation(55, 37.543478, 126.970622);
        locationInfoDatabase.addLocation(56, 37.550142, 126.977389);
        locationInfoDatabase.addLocation(56, 37.548671, 126.982186);
        locationInfoDatabase.addLocation(57, 37.543562, 126.984182);
        locationInfoDatabase.addLocation(57, 37.544199, 126.984437);
        locationInfoDatabase.addLocation(57, 37.544670, 126.985183);
        locationInfoDatabase.addLocation(57, 37.545312, 126.9853117);
        locationInfoDatabase.addLocation(57, 37.545747, 126.985349);
        locationInfoDatabase.addLocation(58, 37.546819, 126.972032);
        locationInfoDatabase.addLocation(58, 37.546747, 126.972962);
        locationInfoDatabase.addLocation(58, 37.545524, 126.973368);
        locationInfoDatabase.addLocation(58, 37.545546, 126.973025);
        locationInfoDatabase.addLocation(58, 37.545181, 126.972510);
        locationInfoDatabase.addLocation(59, 37.53414, 126.990134);
        locationInfoDatabase.addLocation(59, 37.533754, 126.9900349);
        locationInfoDatabase.addLocation(59, 37.533597, 126.990563);
        locationInfoDatabase.addLocation(59, 37.533244, 126.990848);
        locationInfoDatabase.addLocation(59, 37.533099, 126.991126);
        locationInfoDatabase.addLocation(59, 37.532963, 126.991234);
        locationInfoDatabase.addLocation(59, 37.532687, 126.991239);
        locationInfoDatabase.addLocation(59, 37.532406, 126.991384);
        locationInfoDatabase.addLocation(59, 37.532104, 126.991786);
        locationInfoDatabase.addLocation(59, 37.531942, 126.991856);
        locationInfoDatabase.addLocation(59, 37.531810, 126.992103);
        locationInfoDatabase.addLocation(60, 37.542001, 127.002768);
        locationInfoDatabase.addLocation(60, 37.544792, 127.003234);
        locationInfoDatabase.addLocation(60, 37.545512, 127.002864);
        locationInfoDatabase.addLocation(60, 37.545620, 127.002655);
        locationInfoDatabase.addLocation(61, 37.538081, 127.001498);
        locationInfoDatabase.addLocation(61, 37.537921, 127.001852);
        locationInfoDatabase.addLocation(61, 37.537469, 127.002189);
        locationInfoDatabase.addLocation(61, 37.535939, 127.001185);
        locationInfoDatabase.addLocation(61, 37.535927, 127.001442);
        locationInfoDatabase.addLocation(61, 37.535825, 127.001530);
        locationInfoDatabase.addLocation(61, 37.535659, 127.001844);
        locationInfoDatabase.addLocation(61, 37.533600, 127.001594);
        locationInfoDatabase.addLocation(62, 37.532129, 127.005460);
        locationInfoDatabase.addLocation(62, 37.532163, 127.004983);
        locationInfoDatabase.addLocation(62, 37.532095, 127.004725);
        locationInfoDatabase.addLocation(62, 37.531942, 127.004634);
        locationInfoDatabase.addLocation(62, 37.531849, 127.004323);
        locationInfoDatabase.addLocation(62, 37.531895, 127.004173);
        locationInfoDatabase.addLocation(62, 37.531496, 127.003454);
        locationInfoDatabase.addLocation(62, 37.531908, 127.002917);
        locationInfoDatabase.addLocation(62, 37.531785, 127.002402);
        locationInfoDatabase.addLocation(62, 37.531866, 127.002043);
        locationInfoDatabase.addLocation(62, 37.531776, 127.001598);
        locationInfoDatabase.addLocation(63, 37.521204, 126.996981);
        locationInfoDatabase.addLocation(63, 37.521472, 126.996804);
        locationInfoDatabase.addLocation(63, 37.522251, 126.996917);
        locationInfoDatabase.addLocation(63, 37.522510, 126.997062);
        locationInfoDatabase.addLocation(63, 37.522732, 126.997110);
        locationInfoDatabase.addLocation(63, 37.522774, 126.997314);
        locationInfoDatabase.addLocation(64, 37.531552, 126.996609);
        locationInfoDatabase.addLocation(64, 37.531947, 126.997088);
        locationInfoDatabase.addLocation(64, 37.532124, 126.997822);
        locationInfoDatabase.addLocation(64, 37.532341, 126.998153);
        locationInfoDatabase.addLocation(64, 37.532336, 126.998332);
        locationInfoDatabase.addLocation(64, 37.532018, 126.999066);
        locationInfoDatabase.addLocation(65, 37.530348, 126.998160);
        locationInfoDatabase.addLocation(65, 37.530080, 1260998778);
        locationInfoDatabase.addLocation(65, 37.529781, 126.999168);
        locationInfoDatabase.addLocation(65, 37.529341, 127.000169);
        locationInfoDatabase.addLocation(65, 37.528835, 126.999952);
        locationInfoDatabase.addLocation(65, 37.528679, 127.000010);
        locationInfoDatabase.addLocation(65, 37.528082, 126.999174);
        locationInfoDatabase.addLocation(66, 37.527329, 127.000390);
        locationInfoDatabase.addLocation(66, 37.527166, 127.000492);
        locationInfoDatabase.addLocation(66, 37.527545, 127.001014);
        locationInfoDatabase.addLocation(66, 37.527705, 127.001805);
        locationInfoDatabase.addLocation(66, 37.527867, 127.001748);
        locationInfoDatabase.addLocation(66, 37.528021, 127.001802);
        locationInfoDatabase.addLocation(66, 37.528003, 127.002198);
        locationInfoDatabase.addLocation(67, 37.530045, 126.953154);
        locationInfoDatabase.addLocation(67, 37.529326, 126.953738);
        locationInfoDatabase.addLocation(67, 37.528488, 126.953942);
        locationInfoDatabase.addLocation(67, 37.527067, 126.954076);
        locationInfoDatabase.addLocation(68, 37.532158, 126.971004);
        locationInfoDatabase.addLocation(68, 37.531435, 126.972192);
        locationInfoDatabase.addLocation(68, 37.532428, 126.973140);
        locationInfoDatabase.addLocation(69, 37.534925, 126.973798);
        locationInfoDatabase.addLocation(69, 37.532795, 126.973543);
        locationInfoDatabase.addLocation(69, 37.532376, 126.974152);
        locationInfoDatabase.addLocation(70, 37.521630, 126.975381);
        locationInfoDatabase.addLocation(70, 37.520923, 126.975052);
        locationInfoDatabase.addLocation(70, 37.520790, 126.975392);
        locationInfoDatabase.addLocation(70, 37.519629, 126.974783);
        locationInfoDatabase.addLocation(293, 37.549662, 126.851495);
        locationInfoDatabase.addLocation(293, 37.548506, 126.853726);
        locationInfoDatabase.addLocation(294, 37.544196, 126.848860);
        locationInfoDatabase.addLocation(294, 37.545426, 126.848301);
        locationInfoDatabase.addLocation(294, 37.545777, 126.847584);
        locationInfoDatabase.addLocation(295, 37.550924, 126.848843);
        locationInfoDatabase.addLocation(295, 37.551392, 126.848017);
        locationInfoDatabase.addLocation(295, 37.551869, 126.845920);
        locationInfoDatabase.addLocation(296, 37.533414, 126.851184);
        locationInfoDatabase.addLocation(296, 37.530854, 126.851369);
        locationInfoDatabase.addLocation(297, 37.534932, 126.856016);
        locationInfoDatabase.addLocation(297, 37.537086, 126.859355);
        locationInfoDatabase.addLocation(298, 37.537125, 126.859267);
        locationInfoDatabase.addLocation(298, 37.535425, 126.860982);
        locationInfoDatabase.addLocation(298, 37.535544, 126.863353);
        locationInfoDatabase.addLocation(299, 37.563059, 126.815177);
        locationInfoDatabase.addLocation(299, 37.567499, 126.815156);
        locationInfoDatabase.addLocation(300, 37.558419, 126.812297);
        locationInfoDatabase.addLocation(300, 37.561047, 126.812201);
        locationInfoDatabase.addLocation(301, 37.564428, 126.811348);
        locationInfoDatabase.addLocation(301, 37.564309, 126.811627);
        locationInfoDatabase.addLocation(301, 37.563153, 126.813998);
        locationInfoDatabase.addLocation(302, 37.535993, 126.841998);
        locationInfoDatabase.addLocation(302, 37.532675, 126.844058);
        locationInfoDatabase.addLocation(303, 37.540609, 126.841103);
        locationInfoDatabase.addLocation(303, 37.539670, 126.839880);
        locationInfoDatabase.addLocation(303, 37.539268, 126.838943);
        locationInfoDatabase.addLocation(304, 37.535919, 126.842039);
        locationInfoDatabase.addLocation(304, 37.532722, 126.844038);
        locationInfoDatabase.addLocation(305, 37.553022, 126.830884);
        locationInfoDatabase.addLocation(305, 37.550659, 126.832045);
        locationInfoDatabase.addLocation(306, 37.544261, 126.837914);
        locationInfoDatabase.addLocation(306, 37.544452, 126.840235);
        locationInfoDatabase.addLocation(307, 37.550267, 126.870293);
        locationInfoDatabase.addLocation(307, 37.550060, 126.867058);
        locationInfoDatabase.addLocation(308, 37.552603, 126.869978);
        locationInfoDatabase.addLocation(308, 37.553467, 126.871024);
        locationInfoDatabase.addLocation(308, 37.554815, 126.872038);
        locationInfoDatabase.addLocation(309, 37.555320, 126.861995);
        locationInfoDatabase.addLocation(309, 37.553185, 126.860471);
        locationInfoDatabase.addLocation(310, 37.543113, 126.838812);
        locationInfoDatabase.addLocation(310, 37.542805, 126.838314);
        locationInfoDatabase.addLocation(310, 37.542653, 126.836604);
        locationInfoDatabase.addLocation(311, 37.544165, 126.837122);
        locationInfoDatabase.addLocation(311, 37.541940, 126.839216);
        locationInfoDatabase.addLocation(312, 37.549450, 126.862215);
        locationInfoDatabase.addLocation(312, 37.551661, 126.862896);
        locationInfoDatabase.addLocation(313, 37.549709, 126.860950);
        locationInfoDatabase.addLocation(313, 37.54913, 126.863515);
        locationInfoDatabase.addLocation(314, 37.545397, 126.862338);
        locationInfoDatabase.addLocation(314, 37.545545, 126.861665);
        locationInfoDatabase.addLocation(314, 37.545668, 126.861027);
        locationInfoDatabase.addLocation(314, 37.545949, 126.860571);
        locationInfoDatabase.addLocation(314, 37.546723, 126.860018);
        locationInfoDatabase.addLocation(315, 37.578261, 126.814838);
        locationInfoDatabase.addLocation(315, 37.578306, 126.815825);
        locationInfoDatabase.addLocation(315, 37.578162, 126.816603);
        locationInfoDatabase.addLocation(316, 37.577046, 126.815642);
        locationInfoDatabase.addLocation(316, 37.577637, 126.815663);
        locationInfoDatabase.addLocation(316, 37.577900, 126.815583);
        locationInfoDatabase.addLocation(316, 37.528287, 126.815724);
        locationInfoDatabase.addLocation(439, 37.619893, 126.920704);
        locationInfoDatabase.addLocation(439, 37.620142, 126.920551);
        locationInfoDatabase.addLocation(439, 37.620296, 126.920618);
        locationInfoDatabase.addLocation(439, 37.620548, 126.920601);
        locationInfoDatabase.addLocation(439, 37.622295, 126.920158);
        locationInfoDatabase.addLocation(439, 37.622416, 126.920448);
        locationInfoDatabase.addLocation(439, 37.623133, 126.920469);
        locationInfoDatabase.addLocation(439, 37.623880, 126.921048);
        locationInfoDatabase.addLocation(440, 37.618575, 126.921794);
        locationInfoDatabase.addLocation(440, 37.618265, 126.922060);
        locationInfoDatabase.addLocation(440, 37.618401, 126.922320);
        locationInfoDatabase.addLocation(440, 37.618450, 126.922607);
        locationInfoDatabase.addLocation(440, 37.618388, 126.923401);
        locationInfoDatabase.addLocation(440, 37.618369, 126.923492);
        locationInfoDatabase.addLocation(440, 37.618110, 126.923790);
        locationInfoDatabase.addLocation(440, 37.618314, 126.923881);
        locationInfoDatabase.addLocation(440, 37.618579, 126.924093);
        locationInfoDatabase.addLocation(440, 37.618726, 126.924289);
        locationInfoDatabase.addLocation(440, 37.618868, 126.924656);
        locationInfoDatabase.addLocation(440, 37.618996, 126.924914);
        locationInfoDatabase.addLocation(440, 37.618925, 126.925117);
        locationInfoDatabase.addLocation(440, 37.618737, 126.925405);
        locationInfoDatabase.addLocation(440, 37.618517, 126.925712);
        locationInfoDatabase.addLocation(440, 37.618396, 126.926165);
        locationInfoDatabase.addLocation(441, 37.611293, 126.929396);
        locationInfoDatabase.addLocation(441, 37.611536, 126.929180);
        locationInfoDatabase.addLocation(441, 37.611597, 126.929559);
        locationInfoDatabase.addLocation(441, 37.611722, 126.929938);
        locationInfoDatabase.addLocation(441, 37.611783, 126.930334);
        locationInfoDatabase.addLocation(441, 37.611969, 126.930362);
        locationInfoDatabase.addLocation(441, 37.612244, 126.930321);
        locationInfoDatabase.addLocation(441, 37.612422, 126.930064);
        locationInfoDatabase.addLocation(441, 37.612580, 126.929969);
        locationInfoDatabase.addLocation(441, 37.612769, 126.930384);
        locationInfoDatabase.addLocation(441, 37.613155, 126.930375);
        locationInfoDatabase.addLocation(441, 37.613916, 126.930749);
        locationInfoDatabase.addLocation(441, 37.614520, 126.930921);
        locationInfoDatabase.addLocation(442, 37.619312, 126.918056);
        locationInfoDatabase.addLocation(442, 37.618276, 126.917392);
        locationInfoDatabase.addLocation(442, 37.617108, 126.916946);
        locationInfoDatabase.addLocation(442, 37.615234, 126.915268);
        locationInfoDatabase.addLocation(443, 37.610321, 126.916823);
        locationInfoDatabase.addLocation(443, 37.611116, 126.914629);
        locationInfoDatabase.addLocation(443, 37.608519, 126.913170);
        locationInfoDatabase.addLocation(443, 37.608060, 126.912854);
        locationInfoDatabase.addLocation(443, 37.607487, 126.912779);
        locationInfoDatabase.addLocation(444, 37.623615, 126.916969);
        locationInfoDatabase.addLocation(444, 37.624312, 126.916411);
        locationInfoDatabase.addLocation(444, 37.624571, 126.915987);
        locationInfoDatabase.addLocation(444, 37.624678, 126.915858);
        locationInfoDatabase.addLocation(444, 37.625022, 126.915724);
        locationInfoDatabase.addLocation(444, 37.625255, 126.915113);
        locationInfoDatabase.addLocation(444, 37.625574, 126.914699);
        locationInfoDatabase.addLocation(444, 37.625702, 126.914147);
        locationInfoDatabase.addLocation(444, 37.625697, 126.913970);
        locationInfoDatabase.addLocation(444, 37.625795, 126.913535);
        locationInfoDatabase.addLocation(444, 37.626598, 126.912779);
        locationInfoDatabase.addLocation(445, 37.606087, 126.922669);
        locationInfoDatabase.addLocation(445, 37.606755, 126.920395);
        locationInfoDatabase.addLocation(445, 37.606942, 126.919322);
        locationInfoDatabase.addLocation(446, 37.599086, 126.915695);
        locationInfoDatabase.addLocation(446, 37.600335, 126.916028);
        locationInfoDatabase.addLocation(446, 37.602375, 126.915803);
        locationInfoDatabase.addLocation(446, 37.602197, 126.913120);
        locationInfoDatabase.addLocation(446, 37.603260, 126.910352);
        locationInfoDatabase.addLocation(446, 37.601951, 126.910341);
        locationInfoDatabase.addLocation(446, 37.600990, 126.913646);
        locationInfoDatabase.addLocation(446, 37.600106, 126.914397);
        locationInfoDatabase.addLocation(446, 37.60046, 126.914944);
        locationInfoDatabase.addLocation(446, 37.598865, 126.914665);
        locationInfoDatabase.addLocation(446, 37.599077, 126.915674);
        locationInfoDatabase.addLocation(447, 37.607646, 126.921737);
        locationInfoDatabase.addLocation(447, 37.608747, 126.923613);
        locationInfoDatabase.addLocation(447, 37.609029, 126.923302);
        locationInfoDatabase.addLocation(447, 37.609204, 126.922842);
        locationInfoDatabase.addLocation(447, 37.609415, 126.922928);
        locationInfoDatabase.addLocation(447, 37.609640, 126.922391);
        locationInfoDatabase.addLocation(447, 37.610190, 126.922187);
        locationInfoDatabase.addLocation(448, 37.607519, 126.923881);
        locationInfoDatabase.addLocation(448, 37.608422, 126.924115);
        locationInfoDatabase.addLocation(448, 37.608658, 126.9244228);
        locationInfoDatabase.addLocation(448, 37.608954, 126.925880);
        locationInfoDatabase.addLocation(448, 37.609486, 126.925365);
        locationInfoDatabase.addLocation(448, 37.610117, 126.926224);
        locationInfoDatabase.addLocation(448, 37.610402, 126.926895);
        locationInfoDatabase.addLocation(448, 37.610167, 126.927051);
        locationInfoDatabase.addLocation(448, 37.610588, 126.927942);
        locationInfoDatabase.addLocation(448, 37.610068, 126.928254);
        locationInfoDatabase.addLocation(449, 37.612085, 126.919640);
        locationInfoDatabase.addLocation(449, 37.612216, 126.918635);
        locationInfoDatabase.addLocation(449, 37.613642, 126.918878);
        locationInfoDatabase.addLocation(449, 37.613721, 126.918359);
        locationInfoDatabase.addLocation(449, 37.61423, 126.918469);
        locationInfoDatabase.addLocation(449, 37.614088, 126.919054);
        locationInfoDatabase.addLocation(449, 37.614858, 126.919209);
        locationInfoDatabase.addLocation(449, 37.616922, 126.920545);
        locationInfoDatabase.addLocation(449, 37.617447, 126.921484);
        locationInfoDatabase.addLocation(449, 37.618033, 126.920976);
        locationInfoDatabase.addLocation(449, 37.618374, 126.920313);

        locationInfoDatabase.addLocation(29, 37.557439, 126.956850);
        locationInfoDatabase.addLocation(29, 37.557852, 126.956850);
        locationInfoDatabase.addLocation(29, 37.559230, 126.957209);
        locationInfoDatabase.addLocation(29, 37.559821, 126.957558);
        locationInfoDatabase.addLocation(30, 37.564340, 126.958964);
        locationInfoDatabase.addLocation(30, 37.565190, 126.952910);
        locationInfoDatabase.addLocation(30, 37.565129, 126.952623);
        locationInfoDatabase.addLocation(31, 37.555460, 126.937805);
        locationInfoDatabase.addLocation(31, 37.555890, 126.937565);
        locationInfoDatabase.addLocation(31, 37.556258, 126.938639);
        locationInfoDatabase.addLocation(31, 37.556708, 126.938769);
        locationInfoDatabase.addLocation(31, 37.557274, 126.940781);
        locationInfoDatabase.addLocation(32, 37.566637, 126.946573);
        locationInfoDatabase.addLocation(32, 37.566505, 126.946160);
        locationInfoDatabase.addLocation(32, 37.569061, 126.945275);
        locationInfoDatabase.addLocation(33, 37.597803, 126.946559);
        locationInfoDatabase.addLocation(33, 37.597985, 126.946275);
        locationInfoDatabase.addLocation(33, 37.599019, 126.945385);
        locationInfoDatabase.addLocation(34, 37.599884, 126.948740);
        locationInfoDatabase.addLocation(34, 37.599727, 126.949150);
        locationInfoDatabase.addLocation(34, 37.599692, 126.950996);
        locationInfoDatabase.addLocation(35, 37.562774, 126.931438);
        locationInfoDatabase.addLocation(35, 37.563014, 126.931585);
        locationInfoDatabase.addLocation(35, 37.563803, 126.932956);
        locationInfoDatabase.addLocation(35, 37.564015, 126.933092);
        locationInfoDatabase.addLocation(36, 37.568978, 126.918963);
        locationInfoDatabase.addLocation(36, 37.569726, 126.920349);
        locationInfoDatabase.addLocation(36, 37.570164, 126.921862);
        locationInfoDatabase.addLocation(36, 37.570654, 126.922756);
        locationInfoDatabase.addLocation(36, 37.571792, 126.923358);
        locationInfoDatabase.addLocation(37, 37.575075, 126.921585);
        locationInfoDatabase.addLocation(37, 37.576677, 126.923555);
        locationInfoDatabase.addLocation(37, 37.576761, 126.923399);
        locationInfoDatabase.addLocation(37, 37.577317, 126.923433);
        locationInfoDatabase.addLocation(38, 37.579277, 126.923621);
        locationInfoDatabase.addLocation(38, 37.576870, 126.926173);
        locationInfoDatabase.addLocation(39, 37.577474, 126.910245);
        locationInfoDatabase.addLocation(39, 37.580207, 126.912364);
        locationInfoDatabase.addLocation(40, 37.581598, 126.914351);
        locationInfoDatabase.addLocation(40, 37.581651, 126.915628);
        locationInfoDatabase.addLocation(40, 37.581530, 126.915741);
        locationInfoDatabase.addLocation(40, 37.581351, 126.916413);
        locationInfoDatabase.addLocation(40, 37.581144, 126.916638);
        locationInfoDatabase.addLocation(41, 37.588101, 126.944736);
        locationInfoDatabase.addLocation(41, 37.587732, 126.944309);
        locationInfoDatabase.addLocation(41, 37.587475, 126.944149);
        locationInfoDatabase.addLocation(41, 37.585832, 126.944009);
        locationInfoDatabase.addLocation(42, 37.587350, 126.945968);
        locationInfoDatabase.addLocation(42, 37.587601, 126.946749);
        locationInfoDatabase.addLocation(42, 37.587858, 126.947240);
        locationInfoDatabase.addLocation(42, 37.588313, 126.948313);
        locationInfoDatabase.addLocation(43, 37.593505, 126.934447);
        locationInfoDatabase.addLocation(43, 37.593063, 126.932927);
        locationInfoDatabase.addLocation(44, 37.582579, 126.924596);
        locationInfoDatabase.addLocation(44, 37.581942, 126.926123);
        locationInfoDatabase.addLocation(45, 37.587177, 126.999978);
        locationInfoDatabase.addLocation(45, 37.587409, 127.000731);
        locationInfoDatabase.addLocation(45, 37.587756, 127.001164);
        locationInfoDatabase.addLocation(45, 37.588896, 127.001417);
        locationInfoDatabase.addLocation(46, 37.576594, 127.013450);
        locationInfoDatabase.addLocation(46, 37.576961, 127.013575);
        locationInfoDatabase.addLocation(46, 37.576741, 127.014301);
        locationInfoDatabase.addLocation(46, 37.576763, 127.014583);
        locationInfoDatabase.addLocation(46, 37.576693, 127.014822);
        locationInfoDatabase.addLocation(46, 37.576773, 127.015409);
        locationInfoDatabase.addLocation(47, 37.584418, 126.997207);
        locationInfoDatabase.addLocation(47, 37.584329, 126.996968);
        locationInfoDatabase.addLocation(47, 37.584577, 126.995842);
        locationInfoDatabase.addLocation(47, 37.584860, 126.995280);
        locationInfoDatabase.addLocation(47, 37.585967, 126.994559);
        locationInfoDatabase.addLocation(48, 37.583071, 127.004544);
        locationInfoDatabase.addLocation(48, 37.583123, 127.005682);
        locationInfoDatabase.addLocation(48, 37.583193, 127.005932);
        locationInfoDatabase.addLocation(48, 37.583067, 127.006377);
        locationInfoDatabase.addLocation(49, 37.574009, 127.018839);
        locationInfoDatabase.addLocation(49, 37.574382, 127.018668);
        locationInfoDatabase.addLocation(49, 37.574469, 127.018945);
        locationInfoDatabase.addLocation(49, 37.574611, 127.018953);
        locationInfoDatabase.addLocation(49, 37.574701, 127.019127);
        locationInfoDatabase.addLocation(49, 37.575158, 127.019108);
        locationInfoDatabase.addLocation(49, 37.575329, 127.018891);
        locationInfoDatabase.addLocation(49, 37.576151, 127.018843);
        locationInfoDatabase.addLocation(50, 37.571814, 127.010289);
        locationInfoDatabase.addLocation(50, 37.572349, 127.010742);
        locationInfoDatabase.addLocation(50, 37.573862, 127.010587);
        locationInfoDatabase.addLocation(50, 37.574550, 127.010655);
        locationInfoDatabase.addLocation(50, 37.575380, 127.010574);
        locationInfoDatabase.addLocation(51, 37.587744, 126.996654);
        locationInfoDatabase.addLocation(51, 37.588450, 126.995377);
        locationInfoDatabase.addLocation(51, 37.589164, 126.994658);
        locationInfoDatabase.addLocation(51, 37.589491, 126.993913);
        locationInfoDatabase.addLocation(51, 37.591026, 126.992818);
        locationInfoDatabase.addLocation(52, 37.574138, 127.012329);
        locationInfoDatabase.addLocation(52, 37.575088, 127.013345);
        locationInfoDatabase.addLocation(52, 37.575013, 127.013584);
        locationInfoDatabase.addLocation(52, 37.574640, 127.013835);
        locationInfoDatabase.addLocation(52, 37.574953, 127.014745);
        locationInfoDatabase.addLocation(53, 37.579445, 127.009460);
        locationInfoDatabase.addLocation(53, 37.577171, 127.011676);
        locationInfoDatabase.addLocation(53, 37.577052, 127.011992);
        locationInfoDatabase.addLocation(105, 37.551059, 126.955662);
        locationInfoDatabase.addLocation(105, 37.550339, 126.957975);
        locationInfoDatabase.addLocation(106, 37.556949, 126.949841);
        locationInfoDatabase.addLocation(106, 37.555080, 126.949932);
        locationInfoDatabase.addLocation(106, 37.554221, 126.950313);
        locationInfoDatabase.addLocation(107, 37.554338, 126.945912);
        locationInfoDatabase.addLocation(107, 37.554348, 126.947070);
        locationInfoDatabase.addLocation(107, 37.554576, 126.948106);
        locationInfoDatabase.addLocation(107, 37.555013, 126.948550);
        locationInfoDatabase.addLocation(108, 37.556305, 126.946496);
        locationInfoDatabase.addLocation(108, 37.553403, 126.946560);
        locationInfoDatabase.addLocation(109, 37.547288, 126.934779);
        locationInfoDatabase.addLocation(109, 37.546795, 126.935257);
        locationInfoDatabase.addLocation(109, 37.546293, 126.936209);
        locationInfoDatabase.addLocation(109, 37.545775, 126.936445);
        locationInfoDatabase.addLocation(109, 37.545631, 126.936938);
        locationInfoDatabase.addLocation(110, 37.553172, 126.926195);
        locationInfoDatabase.addLocation(110, 37.552836, 126.926133);
        locationInfoDatabase.addLocation(110, 37.552436, 126.926600);
        locationInfoDatabase.addLocation(110, 37.552893, 126.928510);
        locationInfoDatabase.addLocation(110, 37.553571, 126.928384);
        locationInfoDatabase.addLocation(111, 37.554724, 126.930123);
        locationInfoDatabase.addLocation(111, 37.554746, 126.932365);
        locationInfoDatabase.addLocation(111, 37.555912, 126.931878);
        locationInfoDatabase.addLocation(111, 37.556656, 126.931937);
        locationInfoDatabase.addLocation(112, 37.555801, 126.910351);
        locationInfoDatabase.addLocation(112, 37.556188, 126.912227);
        locationInfoDatabase.addLocation(112, 37.556960, 126.914081);
        locationInfoDatabase.addLocation(113, 37.550473, 126.912801);
        locationInfoDatabase.addLocation(113, 37.550187, 126.910093);
        locationInfoDatabase.addLocation(113, 37.549468, 126.909080);
        locationInfoDatabase.addLocation(114, 37.548590, 126.914827);
        locationInfoDatabase.addLocation(114, 37.546663, 126.914288);
        locationInfoDatabase.addLocation(115, 37.568069, 126.907787);
        locationInfoDatabase.addLocation(115, 37.567450, 126.907491);
        locationInfoDatabase.addLocation(115, 37.566584, 126.906793);
        locationInfoDatabase.addLocation(115, 37.564792, 126.907317);
        locationInfoDatabase.addLocation(116, 37.562551, 126.914277);
        locationInfoDatabase.addLocation(116, 37.562836, 126.914832);
        locationInfoDatabase.addLocation(116, 37.563116, 126.916953);
        locationInfoDatabase.addLocation(117, 37.558556, 126.917879);
        locationInfoDatabase.addLocation(117, 37.558946, 126.918348);
        locationInfoDatabase.addLocation(117, 37.559336, 126.918542);
        locationInfoDatabase.addLocation(117, 37.560609, 126.920757);
        locationInfoDatabase.addLocation(118, 37.557748, 126.924715);
        locationInfoDatabase.addLocation(118, 37.558373, 126.923759);
        locationInfoDatabase.addLocation(118, 37.558369, 126.923267);
        locationInfoDatabase.addLocation(118, 37.559521, 126.921757);
        locationInfoDatabase.addLocation(119, 37.564046, 126.925018);
        locationInfoDatabase.addLocation(119, 37.562770, 126.922416);
        locationInfoDatabase.addLocation(120, 37.556571, 126.898683);
        locationInfoDatabase.addLocation(120, 37.557739, 126.904253);
        locationInfoDatabase.addLocation(121, 37.556613, 126.901719);
        locationInfoDatabase.addLocation(121, 37.554397, 126.902436);
        locationInfoDatabase.addLocation(122, 37.576262, 126.893956);
        locationInfoDatabase.addLocation(122, 37.576691, 126.894307);
        locationInfoDatabase.addLocation(122, 37.577467, 126.895679);
        locationInfoDatabase.addLocation(122, 37.577728, 126.896053);
        locationInfoDatabase.addLocation(122, 37.577935, 126.896734);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        FloatingActionButton fab_emergency_call = (FloatingActionButton) findViewById(R.id.fab_emergency_call);
        FloatingActionButton fab_settings = (FloatingActionButton)  findViewById(R.id.fab_settings);
        FloatingActionButton fab_protector =  (FloatingActionButton) findViewById(R.id.fab_contact_protector);
        FloatingActionButton fab_scout = (FloatingActionButton) findViewById(R.id.fab_scout);
        fab_emergency_call.setOnClickListener(this);
        fab_settings.setOnClickListener(this);
        fab_protector.setOnClickListener(this);
        fab_scout.setOnClickListener(this);




    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location initialLocation = locationManager != null ? locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER) : null;
        LatLng lastLatLng = new LatLng(37.59788, 126.86443);
        if (initialLocation != null) {
            lastLatLng = new LatLng(initialLocation.getLatitude(), initialLocation.getLongitude());
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lastLatLng, (float) 15));

        MapInfoDatabase mapInfoDatabase = new MapInfoDatabase(this, "mapinfo.db", null, 1);
        LocationInfoDatabase locationInfoDatabase = new LocationInfoDatabase(this, "locationinfo.db", null, 1);
        DefaultRegionDatabase defaultRegionDatabase = new DefaultRegionDatabase(this, "defaultregion.db", null, 1);
        int idx = 0;
        String district = "마포";
        String region = "상암";
        try {
            String[] DR = defaultRegionDatabase.getDR().split(" ");
            district = DR[0];
            region = DR[1];
        } catch (Exception e){

        }
        idx = mapInfoDatabase.getRegionInfo(district, region);
        ArrayList<Double> points = new ArrayList<>();
        try {
            if (idx == 0) {
                initData(mapInfoDatabase, locationInfoDatabase);
                idx = mapInfoDatabase.getRegionInfo(district, region);
            }

            points = locationInfoDatabase.getLocation(idx);
        } catch (Exception e){

        }
        PolylineOptions polylineOptions = new PolylineOptions();
        for(int i=0; i<points.size();i+=2){
            Log.d("db output point", String.valueOf(points.get(i) + " " +points.get(i+1)));
            polylineOptions.add(new LatLng(points.get(i), points.get(i+1)));
        }
        polylineOptions.width(15)
                .color(Color.argb(255, 114, 62, 189));
                //.geodesic(true);
        Polyline line = mMap.addPolyline(polylineOptions);
        /*
        PolylineOptions polylineOptions = new PolylineOptions()
                .width(25)
                .color(Color.CYAN)
                .geodesic(true);
        //상암 안심길

        for(int i=0; i<points.size();i+=2){
            polylineOptions.add(new LatLng(points.get(i), points.get(i+1)));
        }

        Polyline line = mMap.addPolyline(polylineOptions);
*/

        /*
        mMap.addPolyline((new PolylineOptions()
                .add(new LatLng(37.576278, 126.893896))
                .add(new LatLng(37.577964, 126.896741)).width(200).color(Color.argb(255, 114, 62, 189))));
         */
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_contact_protector:
                UserInfoDatabase userInfoDatabase = new UserInfoDatabase(this, "userinfo.db", null, 1);
                //TODO : USERINFO DB 설계 - 일단 Setting 부분이 확정안됨
                String pNum = null;
                String text = "";
                pNum = userInfoDatabase.getUserInfo();

                //pNum = "01085055354"; 번호 넣고 테스트했을때 문제없음(Permission 요청할때 Send SMS도 추가함)
                text = "지금 출발합니다.";

                if(pNum != null) {  //보호자 전화번호를 DB에서 받아 온 경우
                    final String phoneNo = pNum;
                    final String sms = text;
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                    alertDialogBuilder.setTitle("문자 전송");
                    alertDialogBuilder
                            .setMessage(pNum + "에 출발 문자를 전송하시겠습니까?")
                            .setCancelable(true)
                            .setPositiveButton("전송",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            //문자전송
                                            SmsManager smsManager = SmsManager.getDefault();
                                            smsManager.sendTextMessage("0" + phoneNo, null, sms, null, null);
                                        }
                                    })
                            .setNegativeButton("취소",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();

                } else {    //보호자 전화번호를 DB에서 받아오지 못한 경우
                    Toast.makeText(this, "저장된 보호자 전화번호가 없습니다.\n환경 설정에서 보호자 전화번호를 저장하세요.", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.fab_settings:
                // 비밀번호, 문자 셋팅,
                Intent settingIntent = new Intent(MainActivity.this, SettingActivity.class);
                startActivityForResult(settingIntent, 3000);
                break;

            case R.id.fab_scout:
                Log.d("fab_scout :", "hello");
                Intent dasanCallIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:120"));
                startActivity(dasanCallIntent);
                break;

            case R.id.fab_emergency_call:
                Intent emergencyCallIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:112"));
                startActivity(emergencyCallIntent);
                break;
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            switch (requestCode){
                case 3000:
                    mMap.clear();

                    MapInfoDatabase mapInfoDatabase = new MapInfoDatabase(this, "mapinfo.db", null, 1);
                    LocationInfoDatabase locationInfoDatabase = new LocationInfoDatabase(this, "locationinfo.db", null, 1);
                    int idx = 0;
                    String district = data.getStringExtra("district");
                    String region = data.getStringExtra("region");
                    idx = mapInfoDatabase.getRegionInfo(district, region);
                    ArrayList<Double> points = locationInfoDatabase.getLocation(idx);

                    PolylineOptions polylineOptions = new PolylineOptions();
                    for(int i=0; i<points.size();i+=2){
                        Log.d("db output point", String.valueOf(points.get(i) + " " +points.get(i+1)));
                        polylineOptions.add(new LatLng(points.get(i), points.get(i+1)));
                    }
                    polylineOptions.width(25)
                        .color(Color.argb(255, 114, 62, 189));
                        //.geodesic(true);
                    Polyline line = mMap.addPolyline(polylineOptions);
                    LatLng currentGil = new LatLng(points.get(0), points.get(1));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentGil, (float) 15));
                    break;
            }
        }
    }
}

package edu.citytech.gui.service._13FManagers;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.gui.service._13FManagers.model._13FDetails;
import edu.citytech.gui.service._13FManagers.model._13FManagers;
import edu.citytech.gui.service.service.Calculator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class _13FManagersService {

    private static final String URL = "http://localhost:9215/13F/managers?symbol=$symbol&limit=$limit";
   public static  List<_13FDetails> find13FManagers(String stock, int Limit) {
       String dynamicURL = URL.replace("$symbol", stock)
                .replace("$limit", Limit+"");
        var results = JSONGet.submitGet(dynamicURL, _13FManagers.class);
        List<_13FDetails> list = results.getResults();
        return  list;
    }

}


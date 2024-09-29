package com.mauridemasi.aluraexchange.modelos;

public class Conversion {
    private String result;
    private String time_last_update_utc;
    private String time_next_update_utc;
    private String base_code;
    private String target_code;
    private double conversion_rate;

    public Conversion() {
        this.result = result;
        this.time_last_update_utc = time_last_update_utc;
        this.time_next_update_utc = time_next_update_utc;
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
    }


    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

}

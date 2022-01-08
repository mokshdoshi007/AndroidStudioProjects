package tops.technologies.firebaseimage.Model;

import android.net.Uri;

import com.google.android.gms.tasks.Task;

public class User {
    String key,name, category, description;

    public User(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }
    public User(){}
    public String getKey() { return key; }

    public void setKey(String key) { this.key = key; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

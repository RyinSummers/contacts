package yaoyaoandus.contacts;

/**
 * Created by LJY on 16/9/17.
 */
public class DatabaseUtils {
    final static String create_users="CREATE TABLE users (" +
            "  id INT NOT NULL AUTO_INCREMENT,\n" +
            "  name VARCHAR(64) NOT NULL,\n" +
            "  password VARCHAR(64) NOT NULL,\n" +
            "  nicename VARCHAR(64) NOT NULL,\n" +
            "  picture VARCHAR(255) NOT NULL,\n" +
            "  phone VARCHAR(16) NOT NULL,\n" +
            "  email VARCHAR(255) NOT NULL,\n" +
            "  gender ENUM('male', 'female', 'default') NOT NULL DEFAULT 'default',\n" +
            "  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "  lastlogin_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "  PRIMARY KEY (id),\n" +
            "  INDEX (nicename ASC),\n" +
            "  UNIQUE INDEX (name ASC),\n" +
            "  UNIQUE INDEX (phone ASC),\n" +
            "  UNIQUE INDEX (email ASC)\n" +
            ");";

    final static String create_cards="CREATE TABLE IF NOT EXISTS cards (\n" +
            "  id INT NOT NULL AUTO_INCREMENT,\n" +
            "  user_id INT NOT NULL,\n" +
            "  type ENUM('private', 'public') NOT NULL,\n" +
            "  content TINYTEXT NOT NULL,\n" +
            "  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "  PRIMARY KEY (id),\n" +
            "  INDEX (user_id ASC),\n" +
            "  FOREIGN KEY (user_id) REFERENCES users (id)\n" +
            ");";
    final static String create_groups="CREATE TABLE IF NOT EXISTS groups (\n" +
            "  id INT NOT NULL AUTO_INCREMENT,\n" +
            "  user_id INT NOT NULL,\n" +
            "  name VARCHAR(64) NOT NULL,\n" +
            "  detail VARCHAR(64) NOT NULL,\n" +
            "  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "  PRIMARY KEY (id),\n" +
            "  INDEX (user_id ASC),\n" +
            "  INDEX (name ASC),\n" +
            "  FOREIGN KEY (user_id) REFERENCES users (id)\n" +
            ");";
    final static String create_messages="CREATE TABLE IF NOT EXISTS messages (\n" +
            "  id INT NOT NULL AUTO_INCREMENT,\n" +
            "  sender_id INT NOT NULL,\n" +
            "  receiver_id INT NOT NULL,\n" +
            "  type INT NOT NULL,\n" +
            "  status INT NOT NULL,\n" +
            "  content TINYTEXT NOT NULL,\n" +
            "  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "  PRIMARY KEY (id),\n" +
            "  INDEX (sender_id ASC),\n" +
            "  INDEX (receiver_id ASC),\n" +
            "  FOREIGN KEY (sender_id) REFERENCES users (id),\n" +
            "  FOREIGN KEY (receiver_i) REFERENCES users (id)\n" +
            ");";
    final static String create_tags="CREATE TABLE IF NOT EXISTS tags (\n" +
            "  id INT NOT NULL AUTO_INCREMENT,\n" +
            "  name VARCHAR(64) NOT NULL,\n" +
            "  detail VARCHAR(64) NOT NULL,\n" +
            "  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "  PRIMARY KEY (id),\n" +
            "  UNIQUE INDEX (name ASC)\n" +
            ");";
    final static String create_users_blockeds="CREATE TABLE IF NOT EXISTS users_blockeds (\n" +
            "  id INT NOT NULL AUTO_INCREMENT,\n" +
            "  user_id INT NOT NULL,\n" +
            "  blocked_id INT NOT NULL,\n" +
            "  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "  PRIMARY KEY (id),\n" +
            "  INDEX (user_id ASC),\n" +
            "  INDEX (blocked_id ASC),\n" +
            "  UNIQUE INDEX (user_id ASC, blocked_id ASC),\n" +
            "  FOREIGN KEY (user_id) REFERENCES users (id),\n" +
            "  FOREIGN KEY (blocked_id) REFERENCES users (id)\n" +
            ");\n";
    final static String create_cards_users="CREATE TABLE IF NOT EXISTS cards_users (\n" +
            "  id INT NOT NULL AUTO_INCREMENT,\n" +
            "  card_id INT NOT NULL,\n" +
            "  user_id INT NOT NULL,\n" +
            "  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "  PRIMARY KEY (id),\n" +
            "  INDEX (card_id ASC),\n" +
            "  INDEX (user_id ASC),\n" +
            "  UNIQUE INDEX (card_id ASC, user_id ASC),\n" +
            "  FOREIGN KEY (card_id) REFERENCES cards (id),\n" +
            "  FOREIGN KEY (user_id) REFERENCES users (id)\n" +
            ");\n";
    final static String create_cards_tags="CREATE TABLE IF NOT EXISTS cards_tags (\n" +
            "  id INT NOT NULL AUTO_INCREMENT,\n" +
            "  card_id INT NOT NULL,\n" +
            "  tag_id INT NOT NULL,\n" +
            "  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "  PRIMARY KEY (id),\n" +
            "  INDEX (card_id ASC),\n" +
            "  INDEX (tag_id ASC),\n" +
            "  UNIQUE INDEX (card_id ASC, tag_id ASC),\n" +
            "  FOREIGN KEY (card_id) REFERENCES cards (id),\n" +
            "  FOREIGN KEY (tag_id) REFERENCES tags (id)\n" +
            ");";
    final static String create_cards_groups="CREATE TABLE IF NOT EXISTS cards_groups (\n" +
            "  id INT NOT NULL AUTO_INCREMENT,\n" +
            "  card_id INT NOT NULL,\n" +
            "  group_id INT NOT NULL,\n" +
            "  role ENUM('admin', 'normal') NOT NULL DEFAULT 'normal',\n" +
            "  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
            "  PRIMARY KEY (id),\n" +
            "  INDEX (group_id ASC),\n" +
            "  INDEX (card_id ASC),\n" +
            "  UNIQUE INDEX (card_id ASC, group_id ASC),\n" +
            "  FOREIGN KEY (card_id) REFERENCES cards (id),\n" +
            "  FOREIGN KEY (group_id) REFERENCES groups (id)\n" +
            ");";


}

package com.hms.user.manage.repository;

import com.hms.user.manage.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
/**
 * UserRepository interface provides
 * the abstract methods where the
 * implementation of each provided
 * in the UserRepositoryImpl class
 *
 * @version 1.8
 * @author Vinodya Samarasinghe
 */
public interface UserRepository {
    /**
     * addUser for the user insertion into the database
     * using jdbcTemplate.update
     * @param user userId, userName, userPassword for user
     */
    User addUser(User user);

    /**
     * editUser for updating the user in the database
     * using jdbcTemplate.update
     * @param user userId, userName, userPassword for user
     */
    void editUser(User user);

    /**
     * deleteUser for deleting the user record in the
     * database using jdbcTemplate.update
     * @param userId unique user ID for user
     */
    void deleteUser(int userId);

    /**
     * viewAllUsers for viewing all the user records in the
     * database using jdbcTemplate.query
     */
    List<User> viewAllUsers();

    /**
     * getUser for finding particular user
     * when given the userId using jdbcTemplate.update
     */
    User getUser(int userId);
}
//
//@Repository
//class UserRepositoryImpl implements UserRepository {
//
//    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public User addUser(User user) {
//        String sql = "INSERT INTO user (userid, username, userpassword) VALUES (?, ?, ?)";
//        try {
//            if (!isUserIdExist(user.getUserId())) {
//                jdbcTemplate.update(sql, user.getUserId(), user.getUserName(), user.getUserPassword());
//                logger.info("User {} successfully inserted", user.getUserId());
//                return user;
//            } else {
//                logger.info("Userid exist, please enter the correct userid");
//                return null;
//            }
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//            logger.error("Error occurred while adding user", e);
//            return null;
//        }
//    }
//
//    @Override
//    public void deleteUser(int userId) {
//        String sql = "DELETE FROM user WHERE userid=?";
//        try {
//            if (isUserIdExist(userId)) {
//                jdbcTemplate.update(sql, userId);
//                logger.info("User {} successfully deleted", userId);
//            } else {
//                logger.info("No such userid exist");
//            }
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//            logger.error("Error occurred while deleting the user", e);
//        }
//    }
//
//    public Boolean isUserIdExist(int userId) {
//        String sql = "SELECT username FROM user WHERE userid="+userId;
//        List<User> user = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
//        if (user.size() != 1) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    @Override
//    public List<User> viewAllUsers() {
//        String sql = "SELECT * FROM user";
//        try {
//            List<User> user = jdbcTemplate.query(sql, new ResultSetExtractor<List<User>>(){
//                @Override
//                public List<User> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                    List<User> list = new ArrayList<User>();
//                    if (!resultSet.next()) {
//                        logger.info("No user found");
//                        return null;
//                    } else {
//                        do{
//                            User user = new User();
//                            user.setUserId(resultSet.getInt("userid"));
//                            user.setUserName(resultSet.getString("username"));
//                            user.setUserPassword(resultSet.getString("userpassword"));
//                            list.add(user);
//                        }while (resultSet.next());
//                        logger.info("All users displayed");
//                        return list;
//                    }
//                }
//            });
//            return user;
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//            logger.error("Error occurred while viewing the user", e);
//            return null;
//        }
//    }
//    @Override
//    public User getUser(int userId) {
//        String sql = "SELECT * FROM user where userid="+userId;
//        try {
//            if (isUserIdExist(userId)) {
//                User user = (User) jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class));
//                logger.info("User {} details found", userId);
//                return user;
//            } else {
//                logger.info("No such userid exist");
//                return null;
//            }
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//            logger.error("Error occurred while finding the user", e);
//            return  null;
//        }
//    }
//    @Override
//    public void editUser(User user) {
//        String sql = "UPDATE user SET username=?, userpassword=? WHERE userid=?";
//        try {
//            if (isUserIdExist(user.getUserId())) {
//                jdbcTemplate.update(sql, user.getUserName(), user.getUserPassword(), user.getUserId());
//                logger.info("User {} successfully updated", user.getUserId());
//            } else {
//                logger.info("No such userid exist");
//            }
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//            logger.error("Error occurred while updating the user", e);
//        }
//    }
//}

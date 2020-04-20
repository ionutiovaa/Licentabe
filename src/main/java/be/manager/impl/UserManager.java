package be.manager.impl;

import be.dao.UserDao;
import be.dto.ChangePasswordDTO;
import be.dto.UserDTO;
import be.dtoEntityMappers.UserDTOEntityMapper;
import be.entity.User;
import be.exceptions.BusinessException;
import be.manager.remote.UserManagerRemote;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Logger;

public class UserManager implements UserManagerRemote {

    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    private Logger logger = Logger.getLogger(UserManager.class.getName());

    @Override
    public UserDTO insertUser(UserDTO userDTO) throws BusinessException {
        User user = createUserToInsert(userDTO);
        User persistedUser = userDao.save(user);
        UserDTO dtoPersisted = UserDTOEntityMapper.getDTOFromUser(persistedUser);
        return dtoPersisted;
    }

    private User createUserToInsert(UserDTO userDTO){
        User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getMobileNumber(), userDTO.getEmail(), userDTO.getUsername(), userDTO.getPassword(), userDTO.getEchipe());
        return user;
    }

    @Override
    public UserDTO findUser(Integer id) throws BusinessException {
        User user = userDao.findAllByID(id);
        if (user == null){
            throw new BusinessException("Find user error: ", "No user with this id was found!");
        }
        return UserDTOEntityMapper.getDTOCompleteFromUser(user);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = userDao.findAll();
        return UserDTOEntityMapper.getUserDTOList(users);
    }

    @Override
    public UserDTO findUserByUsernameAndPassword(String username, String password) throws BusinessException {
        User user = userDao.findByUsernameAndPassword(username, password);
        if (user == null){
            throw new BusinessException("Find user error: ", "No user with this username and password was found!");
        }

        return UserDTOEntityMapper.getDTOCompleteFromUser(user);
    }

    @Override
    public UserDTO changePassword(ChangePasswordDTO changePasswordDTO) throws BusinessException {
        User user = this.userDao.findAllByID(changePasswordDTO.getUserId());
        if (user.getPassword().equals(changePasswordDTO.getOldPassword())){
            // Change password;
            user.setPassword(changePasswordDTO.getNewPassword());
            int updated = this.userDao.updatePassword(changePasswordDTO.getUserId(), changePasswordDTO.getNewPassword());
            return UserDTOEntityMapper.getDTOCompleteFromUser(user);
        }
        else throw new BusinessException("Password error", "The old password is wrong");
    }
}

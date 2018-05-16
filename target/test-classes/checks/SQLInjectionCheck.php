<?php

function getGroupsForSolutionist($userId, $organizationId)
    {
        if (!is_object($this->sqlConnection)) return FALSE;
        $st = $this->sqlConnection->prepare('SELECT sections_full.groups_id, sections_full.group_name
						FROM sections_full,team_users
						WHERE sections_full.teams_id=team_users.teams_id AND users_id=:userId
						AND sections_full.acceptor_organizations_id=:organizationId
						GROUP BY sections_full.groups_id');
		$st->bindParam(':userId', $userId, \PDO::PARAM_INT);
		$st->bindParam(':organizationId', $organizationId, \PDO::PARAM_INT);
        $st->execute();
        return $st->fetchAll();
    }

function haveSectionTasks($sectionId)
    {
        if (!is_object($this->sqlConnection)) return FALSE;
        $st = $this->sqlConnection->prepare('SELECT *
				FROM tasks_full
                WHERE sections_id=:sectionId');
        $st->bindParam(':sectionId', $sectionId, \PDO::PARAM_INT);
        $result = $st->execute();
        $selectData = $st->fetchAll();

        if ($result and is_array($selectData)) {
			return count($selectData);
		}

		if (badFunctionExample) {
		    $name = $_GET['username'];
            $result -> query("SELECT password FROM tbl_user WHERE name = '$name' "); // NOK

            $name = "admin' OR 1=1 -- ";
            $result -> query("SELECT password FROM tbl_user WHERE name = '$name' "); // NOK
		}

		if (!is_object($this->sqlConnection)) return FALSE;
                $st = $this->sqlConnection->prepare('SELECT *
        				FROM tasks_full
                        WHERE sections_id=:sectionId');
                $st->bindParam(':sectionId', $sectionId, \PDO::PARAM_INT);
                $result = $st->execute();
                $selectData = $st->fetchAll();

		return FALSE;

    }